
PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

RDEPENDS:${PN} = "\
    packagegroup-citadel-base \
    packagegroup-desktop \
    packagegroup-gnome \
    packagegroup-theme \
    citadel-tools \
    citadel-tools-realms \
    citadel-tools-boot \
    citadel-documentation \
"
