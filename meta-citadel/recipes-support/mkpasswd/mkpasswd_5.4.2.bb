LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://ftp.debian.org/debian/pool/main/w/whois/whois_${PV}.tar.xz"
SRC_URI[md5sum] = "8bbf1105702b9a03445211f45bd53efe"
SRC_URI[sha256sum] = "eee33a3b3a56912fbf115a7dd24ed60314e2707a3ad6aa604ca2752c1ed01f57"
S = "${WORKDIR}/whois-${PV}"

DEPENDS = "libxcrypt libidn2"
RDEPENDS_${PN} = "libxcrypt libidn2"
inherit pkgconfig gettext

do_compile() {
    oe_runmake CC_FOR_BUILD="${BUILD_CC}" BASEDIR=${D}
}

do_install() {
    oe_runmake install-mkpasswd DESTDIR=${D} BASEDIR=${D}
}
