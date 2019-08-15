LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4cb3a392cbf81a9e685ec13b88c4c101"

SRC_URI = "git://github.com/subgraph/gnome-shell-extension-drive-menu.git;protocol=https"
SRCREV="45bbb0e9fe87f1f44d3eec49f31a1efa835f4f6b"
S = "${WORKDIR}/git"

DEPENDS = "gettext-native glib-2.0-native ninja-native"
FILES_${PN} = "${datadir}/gnome-shell/extensions"

EXTRA_OEMESON += "--prefix=${D}/usr"

inherit meson

do_configure_prepend () {
	cd ${S}
	./meson-gse/meson-gse
}
