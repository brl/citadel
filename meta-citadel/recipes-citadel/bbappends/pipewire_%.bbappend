PACKAGECONFIG:remove = "avahi jack libcamera webrtc-echo-cancelling libusb systemd-system-service v4l2"

FILES:${PN} += "\
    ${sysconfdir}/systemd/user/default.target.wants/filter-chain.service \
    ${sysconfdir}/systemd/user/default.target.wants/pipewire.service \
    ${sysconfdir}/systemd/user/sockets.target.wants/pipewire.socket \
"

FILES:${PN}-pulse += "\
    ${sysconfdir}/systemd/user/default.target.wants/pipewire-pulse.service \
    ${sysconfdir}/systemd/user/sockets.target.wants/pipewire-pulse.socket \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/user/default.target.wants
    install -d ${D}${sysconfdir}/systemd/user/sockets.target.wants

    # filter-chain.service
    # [Install]
    # WantedBy=default.target
    ln -sf ${systemd_user_unitdir}/filter-chain.service ${D}${sysconfdir}/systemd/user/default.target.wants/filter-chain.service

    # pipewire.socket
    # [Install]
    # WantedBy=sockets.target
    ln -sf ${systemd_user_unitdir}/pipewire.socket ${D}${sysconfdir}/systemd/user/sockets.target.wants/pipewire.socket

    # pipewire.service
    # [Install]
    # WantedBy=default.target
    ln -sf ${systemd_user_unitdir}/pipewire.service ${D}${sysconfdir}/systemd/user/default.target.wants/pipewire.service

    # pipewire-pulse.socket
    # [Install]
    # WantedBy=sockets.target
    ln -sf ${systemd_user_unitdir}/pipewire-pulse.socket ${D}${sysconfdir}/systemd/user/sockets.target.wants/pipewire-pulse.socket

    # pipewire-pulse.service
    # [Install]
    # WantedBy=default.target
    ln -sf ${systemd_user_unitdir}/pipewire-pulse.service ${D}${sysconfdir}/systemd/user/default.target.wants/pipewire-pulse.service
}
