SUMMARY = "PAM pwdfile library"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "https://github.com/tiwe-de/libpam-pwdfile/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "1546a57bfe50800175f7cbc88ade4a15"
SRC_URI[sha256sum] = "5b8db1397cff9cadfd1bb96f53c134b787ab0e6a0fbedb71040541d340313ba2"

S = "${WORKDIR}/libpam-pwdfile-${PV}"

DEPENDS = "libpam libxcrypt"
inherit lib_package pkgconfig

FILES_${PN} += "${libdir}/security/pam_pwdfile.so"

do_compile_class() {
    oe_runmake CC_FOR_BUILD="${BUILD_CC}" PAM_LIB_DIR=${libdir}/security
}

do_install() {
    oe_runmake install DESTDIR=${D} PAM_LIB_DIR=${libdir}/security
}
