LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2f8a76980411a3f1f1480b141ce06744"

SRC_URI = "git://github.com/sass/sassc.git;protocol=https;branch=master"
SRCREV = "aa6d5c635ea8faf44d542a23aaf85d27e5777d48"

S = "${WORKDIR}/git"

DEPENDS = "libsass"

inherit autotools

EXTRA_OECONF = ""

BBCLASSEXTEND = "native"
