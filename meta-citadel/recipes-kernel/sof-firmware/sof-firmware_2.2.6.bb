DESCRIPTION = "SOF firmware files for use with Linux kernel"
HOMEPAGE = "https://github.com/thesofproject"
SECTION = "kernel"

SRC_URI = "https://github.com/thesofproject/sof-bin/releases/download/v${PV}/sof-bin-v${PV}.tar.gz"
SRC_URI[sha256sum] = "9322c2a7636d02845c3b26984d58ab8f78d63ff4c766d084c3196a585e000905"

S = "${WORKDIR}"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://sof-bin-v${PV}/LICENCE.Intel;md5=54b4f1a2dd35fd85bc7a1d4afa731b78"

FILES:${PN} += "/usr/lib/firmware/intel/*"

inherit allarch update-alternatives

do_install() {
        install -v -d  ${D}/usr/lib/firmware/intel/sof
        install -v -d  ${D}/usr/lib/firmware/intel/sof-tplg
        cp -R ${S}/sof-bin-v${PV}/sof-v${PV}/* ${D}/usr/lib/firmware/intel/sof
        cp -R ${S}/sof-bin-v${PV}/sof-tplg-v${PV}/* ${D}/usr/lib/firmware/intel/sof-tplg
}
