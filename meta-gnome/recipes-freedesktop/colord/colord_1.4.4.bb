SUMMARY = "System service to manage, install and generate color profiles to color manage input and output devices"
HOMEPAGE ="https://www.freedesktop.org/software/colord/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://www.freedesktop.org/software/colord/releases/colord-${PV}.tar.xz" 
SRC_URI[md5sum] = "32c2709a6002d9ee750483aaed6379c8"
SRC_URI[sha256sum] = "9a0fe80160bf88efddb582a9fc0169f56065276dc3882c47dddb9eecd048c0a5"

inherit python3native meson meson-exe-wrapper pkgconfig systemd useradd gettext gobject-introspection

WARN_QA_remove = "unknown-configure-option"

DEPENDS = "glib-2.0-native lcms libgusb libgudev polkit"
EXTRA_OEMESON = "-Dargyllcms_sensor=false -Dman=false -Ddocs=false -Ddaemon_user=colord -Dbash_completion=false -Dtests=false --buildtype=release"

PACKAGES += "${PN}-plugins"

FILES_${PN} += "\
    ${datadir}/glib-2.0/schemas \
    ${datadir}/polkit-1 \
    ${datadir}/dbus-1 \
    ${datadir}/color/icc/colord \
    ${libdir}/tmpfiles.d \
    ${systemd_user_unitdir}/colord-session.service \
"
SYSTEMD_SERVICE_${PN} = "colord.service"

FILES_${PN}-plugins = "\
    ${libdir}/colord-plugins \
    ${libdir}/colord-sensors \
"
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --home /var/lib/colord --no-create-home --shell /bin/false --user-group colord"

