SUMMARY = "configuation database system"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"
SECTION = "x11/gnome"

SRC_URI[archive.sha256sum] = "cf7f22a4c9200421d8d3325c5c1b8b93a36843650c9f95d6451e20f0bcb24533"

DEPENDS = "dbus glib-2.0 xmlto-native glib-2.0-native"

inherit gnomebase bash-completion vala

SRC_URI += "file://0001-meson.build-do-not-compile-docs.patch"

FILES:${PN} += " \
    ${systemd_user_unitdir} \
    ${datadir}/dbus-1 \
    ${libdir}/gio/modules/*.so \
"

EXTRA_OEMESON:append:class-native = "-Dbash_completion=false"

BBCLASSEXTEND= "native"
