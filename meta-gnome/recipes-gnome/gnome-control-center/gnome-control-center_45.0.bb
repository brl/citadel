SUMMARY = "GNOME Settings"
DESCRIPTION = "GNOME Settings is GNOME's main interface for configuration of various aspects of your desktop"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=75859989545e37968a99b631ef42722e"

GNOMEBASEBUILDCLASS = "meson"
GTKIC_VERSION = "4"
export XDG_DATA_DIRS = "${STAGING_DATADIR}:${STAGING_LIBDIR}"

DEPENDS = " \
    accountsservice \
    colord-gtk \
    gcr3 \
    gdk-pixbuf \
    glib-2.0 \
    gnome-bluetooth \
    gnome-desktop \
    gnome-settings-daemon \
    gsettings-desktop-schemas \
    gstreamer1.0-plugins-base \
    gtk4 \
    libadwaita \
    libepoxy \
    libgtop \
    libgudev \
    libnma \
    libpwquality \
    libxml2 \
    modemmanager \
    polkit \
    pulseaudio \
    tecla \
    udisks2 \
    upower \
"
RDEPENDS:${PN} = "gstreamer1.0-plugins-base gstreamer1.0-plugins-good"

inherit gtk-icon-cache pkgconfig gnomebase gsettings gettext upstream-version-is-even bash-completion features_check useradd

REQUIRED_DISTRO_FEATURES += "opengl polkit pulseaudio systemd x11"

SRC_URI += " \
    file://0001-Add-meson-option-to-pass-sysroot.patch \
    file://0002-Don-t-update-icon-cache.patch \
    file://0003-Remove-panels-for-citadel.patch \
"
SRC_URI[archive.sha256sum] = "83df6a90f98914f2c19a872ce06562acef40927637f679c383099265ccfa42cf"


PACKAGECONFIG ??= "ibus ${@bb.utils.filter('DISTRO_FEATURES', 'wayland', d)}"
PACKAGECONFIG[cups] = ",,cups,cups"
PACKAGECONFIG[ibus] = "-Dibus=true, -Dibus=false, ibus"
PACKAGECONFIG[wayland] = "-Dwayland=true, -Dwayland=false, wayland"

EXTRA_OEMESON = " \
    -Doe_sysroot=${STAGING_DIR_HOST} \
"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--system --no-create-home --user-group --home-dir ${sysconfdir}/polkit-1 polkitd"

do_install:append() {
    if [ -d ${D}${datadir}/polkit-1/rules.d ]; then
        chmod 700 ${D}${datadir}/polkit-1/rules.d
        chown polkitd:root ${D}${datadir}/polkit-1/rules.d
    fi
}

FILES:${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/gnome-shell \
    ${datadir}/metainfo \
"

FILES:${PN}-dev += "${datadir}/gettext"

RDEPENDS:${PN} += "gsettings-desktop-schemas"
