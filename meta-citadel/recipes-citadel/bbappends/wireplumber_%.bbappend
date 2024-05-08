PACKAGECONFIG:remove = "systemd-system-service"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/user/pipewire.service.wants

    # wireplumber.service

    # [Install]
    # WantedBy=pipewire.service
    ln -sf ${systemd_user_unitdir}/wireplumber.service ${D}${sysconfdir}/systemd/user/pipewire.service.wants/wireplumber.service
    # Alias=pipewire-session-manager.service
    ln -sf ${systemd_user_unitdir}/wireplumber.service ${D}${sysconfdir}/systemd/user/pipewire-session-manager.service

}
