DESCRIPTION = "Image for rootfs"

NO_RECOMMENDATIONS = "1"

PACKAGE_INSTALL = "\
    citadel-initramfs \
    citadel-tools-boot \
    cryptsetup \
    lvm2 \
    lvm2-udevrules \
    xz \
    tar \
    dconf \
    base-passwd \
    busybox \
    kbd \
    keymaps \
    systemd \
    systemd-initramfs \
    systemd-extra-utils \
    linux-firmware-i915 \
    kernel-module-ansi-cprng \
    kernel-module-apple-bl \
    kernel-module-apple-gmux \
    kernel-module-applesmc \
    kernel-module-appletouch \
    kernel-module-bcm5974 \
    kernel-module-ccm \
    kernel-module-crc32-pclmul \
    kernel-module-crc32c-intel \
    kernel-module-crct10dif-pclmul \
    kernel-module-ecdh-generic \
    kernel-module-ehci-platform \
    kernel-module-ghash-clmulni-intel \
    kernel-module-hid-a4tech \
    kernel-module-hid-apple \
    kernel-module-hid-alps \
    kernel-module-hid-asus \
    kernel-module-hid-aureal \
    kernel-module-hid-belkin \
    kernel-module-hid-cherry \
    kernel-module-hid-cmedia \
    kernel-module-hid-corsair \
    kernel-module-hid-elecom \
    kernel-module-hid-elo \
    kernel-module-hid-ezkey \
    kernel-module-hid-gt683r \
    kernel-module-hid-keytouch \
    kernel-module-hid-kye \
    kernel-module-hid-led \
    kernel-module-hid-logitech \
    kernel-module-hid-logitech-dj \
    kernel-module-hid-logitech-hidpp \
    kernel-module-hid-microsoft \
    kernel-module-hid-monterey \
    kernel-module-hid-ortek \
    kernel-module-hid-penmount \
    kernel-module-hid-plantronics \
    kernel-module-hid-primax \
    kernel-module-hid-rmi \
    kernel-module-hid-roccat \
    kernel-module-hid-roccat-arvo \
    kernel-module-hid-roccat-common \
    kernel-module-hid-roccat-isku \
    kernel-module-hid-roccat-kone \
    kernel-module-hid-roccat-koneplus \
    kernel-module-hid-roccat-konepure \
    kernel-module-hid-roccat-kovaplus \
    kernel-module-hid-roccat-lua \
    kernel-module-hid-roccat-pyra \
    kernel-module-hid-roccat-ryos \
    kernel-module-hid-roccat-savu \
    kernel-module-hid-saitek \
    kernel-module-hid-sensor-hub \
    kernel-module-hid-speedlink \
    kernel-module-hid-uclogic \
    kernel-module-intel-hid \
    kernel-module-intel-ish-ipc \
    kernel-module-intel-ishtp \
    kernel-module-intel-ishtp-hid \
    kernel-module-intel-rng \
    kernel-module-lz4 \
    kernel-module-msi-wmi \
    kernel-module-mxm-wmi \
    kernel-module-radeon \
    kernel-module-radeonfb \
    kernel-module-rmi-core \
    kernel-module-seed \
    kernel-module-serio-raw \
    kernel-module-snd \
    kernel-module-soundcore \
    kernel-module-vmd \
    kernel-module-virtio-gpu \
    kernel-module-xhci-plat-hcd \
    liberation-fonts \
    util-linux-fsck \
    util-linux-lsblk \
    util-linux-losetup \
    util-linux-mount \
    util-linux-umount \
    plymouth \
"

SYSTEMD_DEFAULT_TARGET = "initrd.target"
export IMAGE_BASENAME = "citadel-initramfs-image"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

INITRAMFS_MAXSIZE = "512000"

INITRAMFS_FSTYPES = "cpio.lz4"
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image
require ${THISDIR}/../../recipes-citadel/images/citadel-image.inc

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

IMAGE_NAME_SUFFIX = ""

ROOTFS_POSTPROCESS_COMMAND += "remove_systemd_units; append_initrd_release; "

SYSTEMD_UNITS = "\
    basic.target \
    citadel-install-rootfs-mount.service \
    citadel-lvm-activate.service \
    citadel-rootfs-mount.path \
    citadel-rootfs-mount.service \
    citadel-rootfs-setup.service \
    cryptsetup-pre.target \
    cryptsetup.target \
    debug-shell.service \
    default.target \
    emergency.service \
    emergency.target \
    initrd-cleanup.service \
    initrd-fs.target \
    initrd-parse-etc.service \
    initrd-root-fs.target \
    initrd-switch-root.target \
    initrd-switch-root.service \
    initrd-udevadm-cleanup-db.service \
    initrd.target \
    kmod-static-nodes.service \
    local-fs-pre.target \
    local-fs.target \
    paths.target \
    plymouth-halt.service \
    plymouth-kexec.service \
    plymouth-poweroff.service \
    plymouth-quit-wait.service \
    plymouth-quit.service \
    plymouth-read-write.service \
    plymouth-reboot.service \
    plymouth-start.service \
    plymouth-switch-root.service \
    poweroff.target \
    reboot.target \
    rescue.service \
    rescue.target \
    serial-getty@.service \
    shutdown.target \
    sigpwr.target \
    slices.target \
    sockets.target \
    swap.target \
    sysinit.target \
    systemd-ask-password-console.path \
    systemd-ask-password-console.service \
    systemd-ask-password-plymouth.path \
    systemd-ask-password-plymouth.service \
    systemd-fsck-root.service \
    systemd-fsck@.service \
    systemd-journald-audit.socket \
    systemd-journald.service \
    systemd-journald.socket \
    systemd-modules-load.service \
    systemd-sysctl.service \
    systemd-udev-settle.service \
    systemd-udev-trigger.service \
    systemd-udevd-control.socket \
    systemd-udevd-kernel.socket \
    systemd-udevd.service \
    timers.target \
    umount.target \
"


remove_systemd_wants() {
    for path in ${IMAGE_ROOTFS}${systemd_system_unitdir}/*; do
        if [ -d ${path} ]; then
            [ -h ${path}/${1} ] && rm -v ${path}/${1}
        fi
    done

    local wants_dir=${IMAGE_ROOTFS}${systemd_system_unitdir}/${1}.wants
    [ -d ${wants_dir} ] && rm -rv ${wants_dir}
    return 0
}

remove_one_systemd_unit() {
    local unit_path=${IMAGE_ROOTFS}${systemd_system_unitdir}/${1}

    remove_systemd_wants ${1}

    if [ -e ${unit_path} ]; then
        rm ${unit_path}
    else
        echo "Cannot remove systemd unit ${1} from initramfs image because it does not exist"
    fi
}

match_unit() {
    for unit in ${SYSTEMD_UNITS}; do
        [ ${unit} = ${1} ] && return 0
    done
    return 1
}

remove_systemd_units() {
    for path in ${IMAGE_ROOTFS}${systemd_system_unitdir}/*; do
        if [ ! -d ${path} ]; then
            local unit_name=$(basename ${path})
            match_unit ${unit_name} || remove_one_systemd_unit ${unit_name}
        fi
    done
}


append_initrd_release() {
    KERNEL_ID=$(generate_kernel_id)
    cat >> ${IMAGE_ROOTFS}/etc/initrd-release << EOF
CITADEL_KERNEL_VERSION="${CITADEL_KERNEL_VERSION}"
CITADEL_KERNEL_ID="${KERNEL_ID}"
EOF
}
