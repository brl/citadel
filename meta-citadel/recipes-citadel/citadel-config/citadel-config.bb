DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SECTION = ""
DEPENDS = ""

S = "${WORKDIR}"

DEFAULT_REALM_UNITS = "\
    file://systemd/citadel-launch-default-realm.path \
    file://systemd/citadel-launch-default-realm.service \
"

MODPROBE_CONFIG = "\
    file://modprobe.d/audio_powersave.conf \
"

SYSCTL_CONFIG = "\
    file://sysctl/90-citadel-sysctl.conf \
"

UDEV_RULES = "\
    file://udev/citadel-network.rules \
    file://udev/pci-pm.rules \
    file://udev/udisks2-hide.rules \
"
DEFAULT_PASSWORD = "\
    file://citadel-setpassword.sh \
    file://systemd/citadel-setpassword.service \
"

SRC_URI = "\
    file://locale.conf \
    file://environment.sh \
    file://fstab \
    file://sudo-citadel \
    file://citadel-ifconfig.sh \
    file://00-storage-tmpfiles.conf \
    file://share/dot.bashrc \
    file://share/dot.profile \
    file://share/dot.vimrc \
    file://polkit/citadel.rules \
    file://citadel-installer.session \
    file://citadel-installer.json \
    file://citadel-installer.desktop \
    file://citadel-installer-ui.desktop \
    file://systemd/zram-swap.service \
    file://systemd/x11-session-switcher.service \
    file://systemd/citadel-installer-backend.service \
    file://systemd/installer-session-switcher.service \
    file://systemd/user/gnome-session@citadel-installer.target.d/session.conf \
    file://skel/profile \
    file://skel/bashrc \
    file://skel/vimrc \
    file://skel/init.vim \
    file://apt-cacher-ng/acng.conf \
    file://apt-cacher-ng/security.conf \
    file://iwd/main.conf \
    file://pulse/cookie \
    ${DEFAULT_REALM_UNITS} \
    ${MODPROBE_CONFIG} \
    ${SYSCTL_CONFIG} \
    ${UDEV_RULES} \
    ${DEFAULT_PASSWORD} \
"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-m -u 1000 -s /bin/bash citadel"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# for citadel-ifconfig.sh
RDEPENDS:${PN} = "bash"

inherit allarch systemd useradd

SYSTEMD_SERVICE:${PN} = "zram-swap.service citadel-launch-default-realm.path x11-session-switcher.service citadel-installer-backend.service installer-session-switcher.service citadel-setpassword.service"

do_install() {
    install -m 0755 -d ${D}/storage
    install -m 0755 -d ${D}/realms
    install -d ${D}${libdir}/sysctl.d
    install -m 0755 -d ${D}${libexecdir}
    install -m 0755 -d ${D}${sysconfdir}/profile.d
    install -m 0755 -d ${d}${sysconfdir}/skel
    install -m 0755 -d ${D}${sysconfdir}/skel/.config
    install -m 0755 -d ${D}${sysconfdir}/skel/.config/nvim
    install -m 0755 -d ${D}${sysconfdir}/tmpfiles.d
    install -m 0755 -d ${D}${sysconfdir}/udev/rules.d
    install -m 0755 -d ${D}${sysconfdir}/polkit-1/rules.d
    install -m 0755 -d ${D}${sysconfdir}/modprobe.d
    install -m 0755 -d ${D}${sysconfdir}/sudoers.d
    install -m 0755 -d ${D}${sysconfdir}/iwd
    install -m 0755 -d ${D}${datadir}/factory/home/root
    install -m 0755 -d ${D}${datadir}/factory/home/citadel
    install -m 0755 -d ${D}${datadir}/factory/home/citadel/.local/share/applications
    install -m 0755 -d ${D}${datadir}/factory/home/citadel/.config/pulse
    install -m 0700 -d ${D}${localstatedir}/lib/NetworkManager
    install -m 0700 -d ${D}${localstatedir}/lib/NetworkManager/system-connections
    install -m 0755 -d ${D}${datadir}/citadel
    install -m 0755 -d ${D}${datadir}/gnome-session/sessions
    install -m 0755 -d ${D}${datadir}/gnome-shell/modes
    install -m 0755 -d ${D}${datadir}/applications
    install -m 0755 -d ${D}${datadir}/wayland-sessions

    install -m 0644 ${WORKDIR}/locale.conf ${D}${sysconfdir}/locale.conf
    install -m 0644 ${WORKDIR}/environment.sh ${D}${sysconfdir}/profile.d/environment.sh
    install -m 0644 ${WORKDIR}/fstab ${D}${sysconfdir}/fstab
    install -m 0440 ${WORKDIR}/sudo-citadel ${D}${sysconfdir}/sudoers.d/citadel
    install -m 0644 ${WORKDIR}/00-storage-tmpfiles.conf ${D}${sysconfdir}/tmpfiles.d
    #install -m 0644 ${WORKDIR}/NetworkManager.conf ${D}${sysconfdir}/NetworkManager

    install -d ${D}${systemd_system_unitdir}

    install -m 644 ${WORKDIR}/systemd/zram-swap.service ${D}${systemd_system_unitdir}

    install -m 644 ${WORKDIR}/systemd/x11-session-switcher.service ${D}${systemd_system_unitdir}
    install -m 644 ${WORKDIR}/systemd/citadel-installer-backend.service ${D}${systemd_system_unitdir}
    install -m 644 ${WORKDIR}/systemd/installer-session-switcher.service ${D}${systemd_system_unitdir}

    install -m 644 ${WORKDIR}/systemd/citadel-setpassword.service ${D}${systemd_system_unitdir}
    install -m 0754 ${WORKDIR}/citadel-setpassword.sh ${D}${libexecdir}
    install -d ${D}${systemd_user_unitdir}/gnome-session@citadel-installer.target.d
    install -m 644 ${WORKDIR}/systemd/user/gnome-session@citadel-installer.target.d/session.conf ${D}${systemd_user_unitdir}/gnome-session@citadel-installer.target.d

    install -m 644 ${WORKDIR}/systemd/citadel-launch-default-realm.path ${D}${systemd_system_unitdir}
    install -m 644 ${WORKDIR}/systemd/citadel-launch-default-realm.service ${D}${systemd_system_unitdir}

    # skel files for new realms
    install -m 644 -T ${WORKDIR}/skel/profile ${D}${sysconfdir}/skel/.profile
    install -m 644 -T ${WORKDIR}/skel/bashrc ${D}${sysconfdir}/skel/.bashrc
    install -m 644 -T ${WORKDIR}/skel/vimrc ${D}${sysconfdir}/skel/.vimrc
    install -m 644 -T ${WORKDIR}/skel/init.vim ${D}${sysconfdir}/skel/.config/nvim/init.vim

    install -m 0644 ${WORKDIR}/sysctl/90-citadel-sysctl.conf ${D}${libdir}/sysctl.d/

    install -m 0644 ${WORKDIR}/udev/citadel-network.rules ${D}${sysconfdir}/udev/rules.d/
    install -m 0755 ${WORKDIR}/citadel-ifconfig.sh ${D}${libexecdir}

    install -m 0644 ${WORKDIR}/udev/pci-pm.rules ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 ${WORKDIR}/udev/udisks2-hide.rules ${D}${sysconfdir}/udev/rules.d/

    install -m 0644 ${WORKDIR}/citadel-installer.session ${D}${datadir}/gnome-session/sessions/
    install -m 0644 ${WORKDIR}/citadel-installer.json ${D}${datadir}/gnome-shell/modes/
    install -m 0644 ${WORKDIR}/citadel-installer-ui.desktop ${D}${datadir}/applications/
    install -m 0644 ${WORKDIR}/citadel-installer.desktop ${D}${datadir}/wayland-sessions/

    install -m 0644 ${WORKDIR}/share/dot.bashrc ${D}${datadir}/factory/home/root/.bashrc
    install -m 0644 ${WORKDIR}/share/dot.profile ${D}${datadir}/factory/home/root/.profile
    install -m 0644 ${WORKDIR}/share/dot.vimrc ${D}${datadir}/factory/home/root/.vimrc

    install -m 0644 ${WORKDIR}/share/dot.bashrc ${D}${datadir}/factory/home/citadel/.bashrc
    install -m 0644 ${WORKDIR}/share/dot.profile ${D}${datadir}/factory/home/citadel/.profile
    install -m 0644 ${WORKDIR}/share/dot.vimrc ${D}${datadir}/factory/home/citadel/.vimrc


    # To avoid these warnings:
    #
    #     [pulseaudio] authkey.c: Failed to open cookie file '/home/citadel/.config/pulse/cookie': No such file or directory
    #

    install -m 0600 ${WORKDIR}/pulse/cookie ${D}${datadir}/factory/home/citadel/.config/pulse/cookie


    install -m 0644 ${WORKDIR}/polkit/citadel.rules ${D}${sysconfdir}/polkit-1/rules.d/

    install -m 0644 ${WORKDIR}/modprobe.d/audio_powersave.conf ${D}${sysconfdir}/modprobe.d/

    install -m 0644 ${WORKDIR}/iwd/main.conf ${D}${sysconfdir}/iwd/

    install -d ${D}${datadir}/apt-cacher-ng/conf
    install -m 0644 ${WORKDIR}/apt-cacher-ng/acng.conf ${D}${datadir}/apt-cacher-ng/conf/
    install -m 0644 ${WORKDIR}/apt-cacher-ng/security.conf ${D}${datadir}/apt-cacher-ng/conf/

    # This probably belongs in lvm2 recipe
    install -d ${D}${systemd_system_unitdir}/sysinit.target.wants
    ln -s ../lvm2-lvmetad.socket ${D}${systemd_system_unitdir}/sysinit.target.wants/lvm2-lvmetad.socket

    ln -s /storage/citadel-state/resolv.conf ${D}${sysconfdir}/resolv.conf
    ln -s /dev/null ${D}${sysconfdir}/tmpfiles.d/etc.conf
    ln -s /dev/null ${D}${sysconfdir}/tmpfiles.d/home.conf

    install -d ${D}${datadir}/themes
    install -d ${D}${datadir}/icons
    install -d ${D}${libdir}/modules
    install -d ${D}${libdir}/firmware
    install -d ${D}${datadir}/backgrounds
    install -d ${D}/opt/share
}

FILES:${PN} = "/"
