
PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

RDEPENDS:${PN} = "\
    atk \
    at-spi2-atk \
    zenity \
    gnome-desktop \
    gnome-bluetooth \
    gnome-control-center \
    gnome-screenshot \
    gnome-settings-daemon \
    gnome-terminal \
    gnome-disk-utility \
    gnome-system-monitor \
    libgnome-desktop \
    libsoup \
    mutter \
    gjs \
    gvfs \
    gnome-session \
    gnome-shell \
    hicolor-icon-theme \
    xf86-video-vesa \
    xf86-video-intel \
    xf86-video-modesetting \
    xserver-xorg-extension-glx \
    libdrm-amdgpu \
    dash-to-panel \
    citadel-config-gnome \
    power-profiles-daemon \
"

