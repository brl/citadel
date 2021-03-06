SUMMARY = "GNOME session"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = " \
    glib-2.0-native \
    libxslt-native \
    xmlto-native \
    xtrans \
    libice \
    libsm \
    virtual/libx11 \
    gtk+3 \
    gnome-desktop \
    gsettings-desktop-schemas \
    json-glib \
"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gettext gsettings upstream-version-is-even features_check

REQUIRED_DISTRO_FEATURES = "x11 systemd pam gobject-introspection-data"

SRC_URI[archive.md5sum] = "736024b46e2542b9b68adaa43f754f49"
SRC_URI[archive.sha256sum] = "7bcc0eb2cdba4b3f6d1b459b3a30873b7bb65b383c1f6a5f63c3e3b5c7943d67"
SRC_URI += " file://0001-Disable-sharing-and-usb-protection-add-systemd-to-de.patch"

EXTRA_OEMESON += "-Dsystemd=true -Dsystemd_journal=true -Ddocbook=false -Dman=false"
FILES_${PN} += " \
    ${bindir}/gnome-session \
    ${libexecdir}/gnome-session-ctl \
    ${datadir}/xsessions \
    ${datadir}/wayland-sessions \
    ${systemd_user_unitdir} \
"

RDEPENDS_${PN} += "gnome-shell gnome-settings-daemon gsettings-desktop-schemas"
