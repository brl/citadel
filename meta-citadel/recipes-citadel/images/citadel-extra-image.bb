
DESCRIPTION = "Citadel resources"
LICENSE = "MIT"

PACKAGE_INSTALL = "\
    linux-firmware \
    sof-firmware \
    wireless-regdb-static \
    paper-icon-theme \
    gnome-backgrounds \
    base16-vim \
    adwaita-icon-theme \
    adwaita-icon-theme-cursors \
    adwaita-icon-theme-symbolic \
"

CITADEL_IMAGE_VERSION = "${CITADEL_IMAGE_VERSION_extra}"
CITADEL_IMAGE_TYPE = "extra"

require citadel-image.inc
inherit citadel-image

ROOTFS_POSTPROCESS_COMMAND += "write_manifest_file; "

write_manifest_file() {
    install -m 0755 -d ${IMAGE_ROOTFS}/usr/share/citadel-documentation

    cat > ${IMAGE_ROOTFS}/manifest << EOF
/usr/lib/firmware
/usr/share:/opt/share
/sysroot/usr/share/citadel-documentation:/opt/share/citadel-documentation
EOF
}
