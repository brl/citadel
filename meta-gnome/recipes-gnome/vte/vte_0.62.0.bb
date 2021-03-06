SUMMARY = "Virtual terminal emulator GTK+ widget library"
BUGTRACKER = "https://bugzilla.gnome.org/buglist.cgi?product=vte"
LICENSE = "GPLv3 & LGPLv3+ & LGPLv2.1+"
LICENSE_libvte = "LGPLv3+"

LIC_FILES_CHKSUM = " \
    file://COPYING.GPL3;md5=2f31b266d3440dd7ee50f92cf67d8e6c \
    file://COPYING.LGPL2;md5=4fbd65380cdd255951079008b364516c \
    file://COPYING.LGPL3;md5=b52f2d57d10c4f7ee67a7eb9615d5d24 \
"

DEPENDS = "glib-2.0 gtk+3 libpcre2 libxml2-native gperf-native icu"

GNOMEBASEBUILDCLASS = "meson"
GIR_MESON_OPTION = 'gir'

inherit gnomebase gtk-doc features_check upstream-version-is-even gobject-introspection

SRC_URI[archive.md5sum] = "7562e1dbe1992a48cbcfd10b7acc3ff6"
SRC_URI[archive.sha256sum] = "4d2d246ed47f08cc73f6471aa8e9f378998b7d0f7dcb0c433f29da5839dbb016"

ANY_OF_DISTRO_FEATURES = "${GTK3DISTROFEATURES}"

# Instead of "inherit vala" we do the relevant settings here so we can
# set DEPENDS based on PACKAGECONFIG.

# Our patched version of Vala looks in STAGING_DATADIR for .vapi files
export STAGING_DATADIR
# Upstream Vala >= 0.11 looks in XDG_DATA_DIRS for .vapi files
export XDG_DATA_DIRS = "${STAGING_DATADIR}"

# Help g-ir-scanner find the .so for linking
do_compile_prepend() {
    export GIR_EXTRA_LIBS_PATH="${B}/src/.libs"
}

# Package additional files
FILES_${PN}-dev += "${datadir}/vala/vapi/*"

PACKAGECONFIG ??= "gnutls"
PACKAGECONFIG[vala] = "-Dvapi=true,-Dvapi=false,vala-native vala"
PACKAGECONFIG[gnutls] = "-Dgnutls=true,-Dgnutls=false,gnutls"
PACKAGECONFIG[systemd] = "-D_systemd=true,-D_systemd=false,systemd"
# vala requires gir
PACKAGECONFIG_remove_class-native = "vala"
EXTRA_OECONF = "--with-gnutls"

CFLAGS += "-D_GNU_SOURCE"

PACKAGES =+ "libvte ${PN}-prompt"
FILES_libvte = "${libdir}/*.so.* ${libdir}/girepository-1.0/*"
FILES_${PN}-prompt = " \
    ${sysconfdir}/profile.d \
    ${libexecdir}/vte-urlencode-cwd \
"

BBCLASSEXTEND = "native nativesdk"
