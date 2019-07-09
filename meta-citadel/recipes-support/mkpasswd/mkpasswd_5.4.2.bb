LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/rfc1036/whois/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "e7fce43576e9a3a3f20bef04d7941a8a"
SRC_URI[sha256sum] = "d928b981dc949a2ea1d0512d20da74707953369f889a88d8f84f1a4b05b822d2"
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
