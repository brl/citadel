# Auto-Generated by cargo-bitbake 0.3.10
#
inherit cargo

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get sgmenu could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/sgmenu/0.1.0"
SRC_URI += "git://github.com/subgraph/sgmenu;protocol=https"
SRCREV = "67b2105944771207b8735305bed9226136711467"
S = "${WORKDIR}/git"
CARGO_SRC_DIR=""
PV_append = ".AUTOINC+67b2105944"

# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
crate://crates.io/aho-corasick/0.6.4 \
crate://crates.io/atty/0.2.8 \
crate://crates.io/bitflags/1.0.1 \
crate://crates.io/c_vec/1.2.1 \
crate://crates.io/cairo-rs/0.3.0 \
crate://crates.io/cairo-sys-rs/0.5.0 \
crate://crates.io/cfg-if/0.1.2 \
crate://crates.io/env_logger/0.5.5 \
crate://crates.io/errno/0.1.8 \
crate://crates.io/gdk-pixbuf-sys/0.5.0 \
crate://crates.io/gdk-pixbuf/0.3.0 \
crate://crates.io/gdk-sys/0.5.0 \
crate://crates.io/gdk/0.7.0 \
crate://crates.io/getopts/0.2.17 \
crate://crates.io/gio-sys/0.5.0 \
crate://crates.io/gio/0.3.0 \
crate://crates.io/glib-sys/0.5.0 \
crate://crates.io/glib/0.4.1 \
crate://crates.io/gobject-sys/0.5.0 \
crate://crates.io/humantime/1.1.1 \
crate://crates.io/kernel32-sys/0.2.2 \
crate://crates.io/lazy_static/1.0.0 \
crate://crates.io/libc/0.2.36 \
crate://crates.io/log/0.4.1 \
crate://crates.io/memchr/2.0.1 \
crate://crates.io/pango-sys/0.5.0 \
crate://crates.io/pango/0.3.0 \
crate://crates.io/pkg-config/0.3.9 \
crate://crates.io/pty/0.2.2 \
crate://crates.io/quick-error/1.2.1 \
crate://crates.io/redox_syscall/0.1.37 \
crate://crates.io/redox_termios/0.1.1 \
crate://crates.io/regex-syntax/0.5.0 \
crate://crates.io/regex/0.2.7 \
crate://crates.io/termcolor/0.3.5 \
crate://crates.io/termion/1.5.1 \
crate://crates.io/thread_local/0.3.5 \
crate://crates.io/ucd-util/0.1.1 \
crate://crates.io/unreachable/1.0.0 \
crate://crates.io/utf8-ranges/1.0.0 \
crate://crates.io/void/1.0.2 \
crate://crates.io/winapi-build/0.1.1 \
crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
crate://crates.io/winapi/0.2.8 \
crate://crates.io/winapi/0.3.4 \
crate://crates.io/wincolor/0.1.6 \
"



LIC_FILES_CHKSUM=" \
"

SUMMARY = "sgmenu"
HOMEPAGE = "https://github.com/subgraph/sgmenu"
LICENSE = "CLOSED"

DEPENDS += " glib-2.0-native cairo pango gdk-pixbuf gtk+3"

do_install() {
	 install -d ${D}${bindir}

	 install -m 755 ${B}/target/${CARGO_TARGET_SUBDIR}/sgmenu ${D}${bindir}
}

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include sgmenu-${PV}.inc
include sgmenu.inc