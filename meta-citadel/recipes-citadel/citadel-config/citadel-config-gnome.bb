DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "dconf-native"

S = "${WORKDIR}"

SRC_URI = "\
    file://gsettings/90_citadel.gschema.override \
    file://gsettings/com.subgraph.RealmConfig.gschema.xml \
    file://dconf/build.d/realms.d/initial-realm-dconf.conf \
    file://dconf/build.d/citadel.d/citadel-dconf.conf \
"

inherit allarch gsettings

do_compile() {
    mkdir -p ${WORKDIR}/dconf-output
    # Build the binary dconf database which is installed by default into each new realm
    dconf compile ${WORKDIR}/dconf-output/user ${S}/dconf/build.d/realms.d/
    # Build the binary dconf database which is installed by default into /home/citadel
    dconf compile ${WORKDIR}/dconf-output/citadel ${S}/dconf/build.d/citadel.d/
}

do_install() {
    install -d ${D}${datadir}/glib-2.0/schemas
    install -d ${D}${sysconfdir}/skel/.config/dconf
    install -m 0755 -d ${D}${datadir}/factory/storage/citadel-state/citadel-dconf

    install -m 644 ${S}/gsettings/90_citadel.gschema.override ${D}${datadir}/glib-2.0/schemas
    install -m 644 ${S}/gsettings/com.subgraph.RealmConfig.gschema.xml ${D}${datadir}/glib-2.0/schemas
    install -m 644 ${WORKDIR}/dconf-output/user ${D}${sysconfdir}/skel/.config/dconf
    install -m 644 ${WORKDIR}/dconf-output/citadel ${D}${datadir}/factory/storage/citadel-state/citadel-dconf/user
}

FILES:${PN} = "/"
