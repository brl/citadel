DESCRIPTION = "Citadel linux kernel"
LICENSE = "GPLv2"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel 

SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-5.0.6.tar.xz\
    file://0117-WireGuard.patch \
    file://defconfig \
"
SRC_URI[md5sum] = "301cf9a7706c750ca76b322eb98bfe15"
SRC_URI[sha256sum] = "9e4a9a8d8a07b7fc696d734f6e822cf43c45cecfe3ab4c089b349bfc701ff413"

LINUX_VERSION ?= "${PV}"
S = "${WORKDIR}/linux-${LINUX_VERSION}"

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

DEPENDS += "lz4-native"

do_deploy_append() {
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
RDEPENDS_${KERNEL_PACKAGE_NAME}-base = ""

