#
# Packages common to any desktop environment
#

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

CITADEL_POWERTOP = ""
# append only if citadel-powertop override is set
CITADEL_POWERTOP:append:citadel-powertop= "powertop"

RDEPENDS:${PN} = "\
    ${CITADEL_POWERTOP} \
    accountsservice \
    upower \
    colord \
    gdm \
    plymouth \
    shared-mime-info \
    sound-theme-freedesktop \
    iso-codes \
    libgudev \
    networkmanager \
    iwd \
    wireless-regdb \
    polkit \
    network-manager-applet \
    libxkbcommon \
    xkeyboard-config \
    libusb1 \
    dbus-glib \
    gtk+3 \
    libnotify \
    ttf-bitstream-vera \
    ttf-dejavu-sans-mono \
    startup-notification \
    gconf \
    gcr \
    dconf \
    ibus \
    libsecret \
    libwacom \
    libcroco \
    librsvg \
    librsvg-gtk \
    glib-2.0-utils \
    virglrenderer \
    rtkit \
    libcanberra-pulse \
    pipewire-tools \
    pipewire-spa-tools \
    alsa-utils \
"
