SUMMARY = "Plymouth is a project from Fedora providing a flicker-free graphical boot process."

DESCRIPTION = "Plymouth is an application that runs very early in the boot process \
    (even before the root filesystem is mounted!) that provides a \
    graphical boot animation while the boot process happens in the background. \
"

HOMEPAGE = "http://www.freedesktop.org/wiki/Software/Plymouth"
SECTION = "base"

LICENSE = "GPL-2.0-or-later"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "libcap libpng cairo dbus udev"
DEPENDS:append:libc-musl = " musl-rpmatch"
PROVIDES = "virtual/psplash"
RPROVIDES:${PN} = "virtual-psplash virtual-psplash-support"

SRCREV = "e96011133a2ac44ee2a42fb8231144c4c799151d"
SRC_URI = " \
    git://gitlab.freedesktop.org/plymouth/plymouth.git;branch=main;protocol=https \
    file://0001-Make-full-path-to-systemd-tty-ask-password-agent-con.patch \
    file://plymouthd.conf \
        "
S = "${WORKDIR}/git"

EXTRA_OECONF += " --enable-shared --disable-static --disable-documentation \
    --with-logo=${LOGO} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '--enable-systemd-integration --with-systemd-tty-ask-password-agent=${base_bindir}/systemd-tty-ask-password-agent', '--disable-systemd-integration', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'usrmerge','--without-system-root-install','--with-system-root-install',d)} \
"

PACKAGECONFIG ??= "pango initrd"
PACKAGECONFIG:append:x86 = " drm"
PACKAGECONFIG:append:x86-64 = " drm"

PACKAGECONFIG[drm] = "--enable-drm,--disable-drm,libdrm"
PACKAGECONFIG[pango] = "--enable-pango,--disable-pango,pango"
PACKAGECONFIG[gtk] = "--enable-gtk,--disable-gtk,gtk+3"
PACKAGECONFIG[initrd] = ",,,"

LOGO ??= "${datadir}/plymouth/bizcom.png"

inherit autotools pkgconfig systemd gettext

LDFLAGS:append:libc-musl = " -lrpmatch"

do_install:append() {
    # Remove /var/run from package as plymouth will populate it on startup
    rm -fr "${D}${localstatedir}/run"

    if ! ${@bb.utils.contains('PACKAGECONFIG', 'initrd', 'true', 'false', d)}; then
        rm -rf "${D}${libexecdir}"
    fi
    rm -rf ${D}/etc/plymouth/plymouthd.conf
    install -m 644 ${WORKDIR}/plymouthd.conf ${D}/etc/plymouth/plymouthd.conf
}

do_configure:prepend() {
    touch ${S}/ABOUT-NLS
    mkdir -p ${S}/build-tools
    touch ${S}/build-tools/config.rpath
}

PACKAGES =. "${@bb.utils.contains('PACKAGECONFIG', 'initrd', '${PN}-initrd ', '', d)}"
PACKAGES =+ "${PN}-set-default-theme"

FILES:${PN}-initrd = "${libexecdir}/plymouth/*"
FILES:${PN}-set-default-theme = "${sbindir}/plymouth-set-default-theme"

FILES:${PN} += "${systemd_unitdir}/system/*"
FILES:${PN}-dbg += "${libdir}/plymouth/renderers/.debug"


RDEPENDS:${PN}-initrd = "bash dracut"
RDEPENDS:${PN}-set-default-theme = "bash"

SYSTEMD_SERVICE:${PN} = "plymouth-start.service"

