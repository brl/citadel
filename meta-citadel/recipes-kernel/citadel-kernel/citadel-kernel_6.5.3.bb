DESCRIPTION = "Citadel linux kernel"
LICENSE = "GPL-2.0-only"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel 

SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v6.x/linux-${PV}.tar.xz\
    file://defconfig \
"

SRC_URI[sha256sum] = "4cac13f7b17bd8dcf9032ad68f9123ab5313d698c9f59416043165150763eb4f"

LINUX_VERSION ?= "${PV}"
S = "${WORKDIR}/linux-${LINUX_VERSION}"

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

DEPENDS += "lz4-native"

do_deploy:append() {
    rm ${DEPLOYDIR}/bzImage
    ln -sf bzImage-initramfs-${KERNEL_IMAGE_NAME}.bin ${DEPLOYDIR}/bzImage
    echo "${PV}" > ${DEPLOYDIR}/kernel.version
}

#
# Replaces function with same name in kernel.bbclass since that implementation
# doesn't pass destination argument to lz4 in which case the decompressed output
# just disappears into thin air it seems.
#
copy_initramfs() {
    echo "copy_initramfs override"
    mkdir -p ${B}/usr
    rm -f ${B}/usr/${INITRAMFS_IMAGE_NAME}.cpio
    cp ${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE_NAME}.cpio.lz4 ${B}/usr/.
    lz4 -df ${B}/usr/${INITRAMFS_IMAGE_NAME}.cpio.lz4 ${B}/usr/${INITRAMFS_IMAGE_NAME}.cpio
    ls -al ${B}/usr
    echo "Finished copy of initramfs into ./usr"
}

# Don't install kernel into images, see kernel.bbclass
RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

