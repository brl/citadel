LICENSE = "GPL-2.0-only" 
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

REQUIRED_DISTRO_FEATURES = "x11 systemd pam"

GIR_MESON_OPTION = ""
GTKIC_VERSION = "4"

SRCREV = "4474416d653af44a9ba9724583ddff091a92a948"

EXTERNAL_TREE_VAR="CITADEL_GNOME_SHELL_PATH"
GIT_URI = "gitsm://github.com/brl/gnome-shell.git;branch=citadel-45.0;protocol=https"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    libxml2-native \
    sassc-native \
    gtk4 \
    mutter \
    gcr \
    gjs \
    network-manager-applet \
    gnome-autoar \
    polkit \
    libsoup-3.0 \
    libcroco \
    startup-notification \
    ibus \
    gsettings-desktop-schemas \
"

inherit gnomebase gsettings gettext gobject-introspection gtk-icon-cache features_check external-tree

RDEPENDS:${PN} = "gsettings-desktop-schemas librsvg-gtk tecla"

FILES:${PN} += "\
    ${datadir}/dbus-1 \
    ${datadir}/xdg-desktop-portal \
    ${datadir}/gnome-control-center  \
    ${datadir}/bash-completion/completions/gnome-extensions \
    ${systemd_user_unitdir} \
"

PACKAGES =+ "${PN}-tools"
FILES:${PN}-tools += "\
    /usr/bin/gnome-shell-perf-tool \
    /usr/bin/gnome-shell-extension-tool \
"

do_compile:prepend() {
    rm -f ${B}/data/theme/*.css
}

do_configure:append () {
    MUTTER_DIR="/usr/lib/mutter"
    sed --in-place=.old1 "s;=${MUTTER_DIR};=${PKG_CONFIG_SYSROOT_DIR}${MUTTER_DIR};" ${B}/build.ninja
}

EXTRA_OEMESON += "-Dman=false -Dsystemd=true -Dnetworkmanager=true -Dextensions_app=false -Dtests=false -Dcamera_monitor=false"
