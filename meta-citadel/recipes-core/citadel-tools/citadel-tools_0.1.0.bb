SUMMARY = "${PN}"
HOMEPAGE = "http://github.com/subgraph/citadel"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM=""

inherit cargo systemd gsettings pkgconfig

#
# Update this when changes are pushed to github
#
SRCREV = "c79ff22a987ea5c9621db88df5ec638439011b3e"

GIT_URI = "git://github.com/brl/citadel-tools.git;protocol=https;branch=master"

# If Cargo.lock changes in citadel-tools, this needs to be updated.
# cargo bitbake does not support workspaces so as a workaround first
# copy the Cargo.lock file into one of the tool subdirectories. In
# that subdirectory run "cargo bitbake" and it will produce a bitbake
# recipe file with the correct set of dependencies for the Cargo.lock
# file.  Copy just the SRC_URI variable from that file here to update
# the dependency list.

SRC_URI += " \
    crate://crates.io/acl-sys/1.2.2 \
    crate://crates.io/addr2line/0.17.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aho-corasick/0.7.18 \
    crate://crates.io/ansi_term/0.12.1 \
    crate://crates.io/anyhow/1.0.57 \
    crate://crates.io/array-macro/1.0.5 \
    crate://crates.io/async-broadcast/0.3.4 \
    crate://crates.io/async-channel/1.6.1 \
    crate://crates.io/async-executor/1.4.1 \
    crate://crates.io/async-io/1.6.0 \
    crate://crates.io/async-lock/2.5.0 \
    crate://crates.io/async-task/4.2.0 \
    crate://crates.io/atk-sys/0.14.0 \
    crate://crates.io/atk/0.14.0 \
    crate://crates.io/atty/0.2.14 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/backtrace/0.3.65 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bitflags/1.2.1 \
    crate://crates.io/block-buffer/0.9.0 \
    crate://crates.io/block-cipher/0.7.1 \
    crate://crates.io/blowfish/0.5.0 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/cache-padded/1.2.0 \
    crate://crates.io/cairo-rs/0.14.9 \
    crate://crates.io/cairo-sys-rs/0.14.9 \
    crate://crates.io/cc/1.0.73 \
    crate://crates.io/cfg-expr/0.8.1 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.19 \
    crate://crates.io/clap/2.34.0 \
    crate://crates.io/concurrent-queue/1.2.2 \
    crate://crates.io/cpufeatures/0.2.2 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crossbeam-channel/0.3.9 \
    crate://crates.io/crossbeam-utils/0.6.6 \
    crate://crates.io/crypto-mac/0.8.0 \
    crate://crates.io/cursive/0.11.0 \
    crate://crates.io/dbus/0.6.5 \
    crate://crates.io/dbus/0.8.4 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/digest/0.9.0 \
    crate://crates.io/easy-parallel/3.2.0 \
    crate://crates.io/ed25519/1.5.2 \
    crate://crates.io/either/1.6.1 \
    crate://crates.io/enum-map-derive/0.4.6 \
    crate://crates.io/enum-map-internals/0.1.2 \
    crate://crates.io/enum-map/0.5.0 \
    crate://crates.io/enumflags2/0.6.4 \
    crate://crates.io/enumflags2_derive/0.6.4 \
    crate://crates.io/enumset/0.3.19 \
    crate://crates.io/enumset_derive/0.3.2 \
    crate://crates.io/event-listener/2.5.2 \
    crate://crates.io/failure/0.1.8 \
    crate://crates.io/failure_derive/0.1.8 \
    crate://crates.io/fastrand/1.7.0 \
    crate://crates.io/field-offset/0.3.4 \
    crate://crates.io/flate2/1.0.24 \
    crate://crates.io/futures-channel/0.3.21 \
    crate://crates.io/futures-core/0.3.21 \
    crate://crates.io/futures-executor/0.3.21 \
    crate://crates.io/futures-io/0.3.21 \
    crate://crates.io/futures-lite/1.12.0 \
    crate://crates.io/futures-macro/0.3.21 \
    crate://crates.io/futures-sink/0.3.21 \
    crate://crates.io/futures-task/0.3.21 \
    crate://crates.io/futures-util/0.3.21 \
    crate://crates.io/gdk-pixbuf-sys/0.14.0 \
    crate://crates.io/gdk-pixbuf/0.14.0 \
    crate://crates.io/gdk-sys/0.14.0 \
    crate://crates.io/gdk/0.14.3 \
    crate://crates.io/generic-array/0.14.5 \
    crate://crates.io/getrandom/0.1.16 \
    crate://crates.io/getrandom/0.2.6 \
    crate://crates.io/gimli/0.26.1 \
    crate://crates.io/gio-sys/0.14.0 \
    crate://crates.io/gio/0.14.8 \
    crate://crates.io/glib-macros/0.10.1 \
    crate://crates.io/glib-macros/0.14.1 \
    crate://crates.io/glib-sys/0.10.1 \
    crate://crates.io/glib-sys/0.14.0 \
    crate://crates.io/glib/0.10.3 \
    crate://crates.io/glib/0.14.8 \
    crate://crates.io/gobject-sys/0.10.0 \
    crate://crates.io/gobject-sys/0.14.0 \
    crate://crates.io/gtk-sys/0.14.0 \
    crate://crates.io/gtk/0.14.3 \
    crate://crates.io/gtk3-macros/0.14.0 \
    crate://crates.io/heck/0.3.3 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hmac/0.8.1 \
    crate://crates.io/inotify-sys/0.1.5 \
    crate://crates.io/inotify/0.8.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/itertools/0.10.3 \
    crate://crates.io/itertools/0.9.0 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.126 \
    crate://crates.io/libdbus-sys/0.2.2 \
    crate://crates.io/libsodium-sys/0.2.7 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/md-5/0.9.1 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/miniz_oxide/0.5.1 \
    crate://crates.io/nix/0.17.0 \
    crate://crates.io/nix/0.21.2 \
    crate://crates.io/num-complex/0.2.4 \
    crate://crates.io/num-integer/0.1.45 \
    crate://crates.io/num-iter/0.1.43 \
    crate://crates.io/num-rational/0.2.4 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/num/0.2.1 \
    crate://crates.io/numtoa/0.1.0 \
    crate://crates.io/object/0.28.4 \
    crate://crates.io/once_cell/1.10.0 \
    crate://crates.io/opaque-debug/0.2.3 \
    crate://crates.io/opaque-debug/0.3.0 \
    crate://crates.io/owning_ref/0.4.1 \
    crate://crates.io/pango-sys/0.10.0 \
    crate://crates.io/pango-sys/0.14.0 \
    crate://crates.io/pango/0.14.8 \
    crate://crates.io/pango/0.9.1 \
    crate://crates.io/parking/2.0.0 \
    crate://crates.io/pest/2.1.3 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.25 \
    crate://crates.io/polling/2.2.0 \
    crate://crates.io/posix-acl/1.0.0 \
    crate://crates.io/ppv-lite86/0.2.16 \
    crate://crates.io/proc-macro-crate/0.1.5 \
    crate://crates.io/proc-macro-crate/1.1.3 \
    crate://crates.io/proc-macro-error-attr/1.0.4 \
    crate://crates.io/proc-macro-error/1.0.4 \
    crate://crates.io/proc-macro2/0.4.30 \
    crate://crates.io/proc-macro2/1.0.39 \
    crate://crates.io/procfs/0.12.0 \
    crate://crates.io/pwhash/0.3.1 \
    crate://crates.io/quote/0.6.13 \
    crate://crates.io/quote/1.0.18 \
    crate://crates.io/rand/0.7.3 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.2.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.5.1 \
    crate://crates.io/rand_core/0.6.3 \
    crate://crates.io/rand_hc/0.2.0 \
    crate://crates.io/redox_syscall/0.2.13 \
    crate://crates.io/redox_termios/0.1.2 \
    crate://crates.io/regex-syntax/0.6.25 \
    crate://crates.io/regex/1.5.5 \
    crate://crates.io/remove_dir_all/0.5.3 \
    crate://crates.io/rpassword/4.0.5 \
    crate://crates.io/rustc-demangle/0.1.21 \
    crate://crates.io/rustc_version/0.3.3 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/scoped-tls/1.0.0 \
    crate://crates.io/semver-parser/0.10.2 \
    crate://crates.io/semver/0.11.0 \
    crate://crates.io/serde/1.0.137 \
    crate://crates.io/serde_derive/1.0.137 \
    crate://crates.io/serde_repr/0.1.8 \
    crate://crates.io/sha-1/0.9.8 \
    crate://crates.io/sha1/0.6.1 \
    crate://crates.io/sha1_smol/1.0.0 \
    crate://crates.io/sha2/0.9.9 \
    crate://crates.io/signal-hook-registry/1.4.0 \
    crate://crates.io/signal-hook/0.1.17 \
    crate://crates.io/signature/1.5.0 \
    crate://crates.io/slab/0.4.6 \
    crate://crates.io/slotmap/1.0.6 \
    crate://crates.io/smallvec/1.8.0 \
    crate://crates.io/socket2/0.4.4 \
    crate://crates.io/sodiumoxide/0.2.7 \
    crate://crates.io/stable_deref_trait/1.2.0 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.8.0 \
    crate://crates.io/strum/0.18.0 \
    crate://crates.io/strum/0.21.0 \
    crate://crates.io/strum_macros/0.18.0 \
    crate://crates.io/strum_macros/0.21.1 \
    crate://crates.io/subtle/2.4.1 \
    crate://crates.io/syn/0.15.44 \
    crate://crates.io/syn/1.0.95 \
    crate://crates.io/synstructure/0.12.6 \
    crate://crates.io/system-deps/1.3.2 \
    crate://crates.io/system-deps/3.2.0 \
    crate://crates.io/tempfile/3.3.0 \
    crate://crates.io/termion/1.5.6 \
    crate://crates.io/textwrap/0.11.0 \
    crate://crates.io/thiserror-impl/1.0.31 \
    crate://crates.io/thiserror/1.0.31 \
    crate://crates.io/time/0.1.43 \
    crate://crates.io/toml/0.4.10 \
    crate://crates.io/toml/0.5.9 \
    crate://crates.io/typenum/1.15.0 \
    crate://crates.io/ucd-trie/0.1.3 \
    crate://crates.io/unicode-ident/1.0.0 \
    crate://crates.io/unicode-segmentation/1.9.0 \
    crate://crates.io/unicode-width/0.1.9 \
    crate://crates.io/unicode-xid/0.1.0 \
    crate://crates.io/unicode-xid/0.2.3 \
    crate://crates.io/vec_map/0.8.2 \
    crate://crates.io/version-compare/0.0.10 \
    crate://crates.io/version-compare/0.0.11 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/void/1.0.2 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/walkdir/2.3.2 \
    crate://crates.io/wasi/0.10.2+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wepoll-ffi/0.1.2 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/xi-unicode/0.1.0 \
    crate://crates.io/zbus/2.0.0-beta.5 \
    crate://crates.io/zbus_macros/2.0.0-beta.5 \
    crate://crates.io/zvariant/2.10.0 \
    crate://crates.io/zvariant_derive/2.10.0 \
"

SRC_URI[acl-sys-1.2.2.sha256sum] = "bbc079f9bdd3124fd18df23c67f7e0f79d24751ae151dcffd095fcade07a3eb2"
SRC_URI[addr2line-0.17.0.sha256sum] = "b9ecd88a8c8378ca913a680cd98f0f13ac67383d35993f86c90a70e3f137816b"
SRC_URI[adler-1.0.2.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[aho-corasick-0.7.18.sha256sum] = "1e37cfd5e7657ada45f742d6e99ca5788580b5c529dc78faf11ece6dc702656f"
SRC_URI[ansi_term-0.12.1.sha256sum] = "d52a9bb7ec0cf484c551830a7ce27bd20d67eac647e1befb56b0be4ee39a55d2"
SRC_URI[anyhow-1.0.57.sha256sum] = "08f9b8508dccb7687a1d6c4ce66b2b0ecef467c94667de27d8d7fe1f8d2a9cdc"
SRC_URI[array-macro-1.0.5.sha256sum] = "06e97b4e522f9e55523001238ac59d13a8603af57f69980de5d8de4bbbe8ada6"
SRC_URI[async-broadcast-0.3.4.sha256sum] = "90622698a1218e0b2fb846c97b5f19a0831f6baddee73d9454156365ccfa473b"
SRC_URI[async-channel-1.6.1.sha256sum] = "2114d64672151c0c5eaa5e131ec84a74f06e1e559830dabba01ca30605d66319"
SRC_URI[async-executor-1.4.1.sha256sum] = "871f9bb5e0a22eeb7e8cf16641feb87c9dc67032ccf8ff49e772eb9941d3a965"
SRC_URI[async-io-1.6.0.sha256sum] = "a811e6a479f2439f0c04038796b5cfb3d2ad56c230e0f2d3f7b04d68cfee607b"
SRC_URI[async-lock-2.5.0.sha256sum] = "e97a171d191782fba31bb902b14ad94e24a68145032b7eedf871ab0bc0d077b6"
SRC_URI[async-task-4.2.0.sha256sum] = "30696a84d817107fc028e049980e09d5e140e8da8f1caeb17e8e950658a3cea9"
SRC_URI[atk-sys-0.14.0.sha256sum] = "badcf670157c84bb8b1cf6b5f70b650fed78da2033c9eed84c4e49b11cbe83ea"
SRC_URI[atk-0.14.0.sha256sum] = "a83b21d2aa75e464db56225e1bda2dd5993311ba1095acaa8fa03d1ae67026ba"
SRC_URI[atty-0.2.14.sha256sum] = "d9b39be18770d11421cdb1b9947a45dd3f37e93092cbf377614828a319d5fee8"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[backtrace-0.3.65.sha256sum] = "11a17d453482a265fd5f8479f2a3f405566e6ca627837aaddb85af8b1ab8ef61"
SRC_URI[bincode-1.3.3.sha256sum] = "b1f45e9417d87227c7a56d22e471c6206462cba514c7590c09aff4cf6d1ddcad"
SRC_URI[bitflags-1.2.1.sha256sum] = "cf1de2fe8c75bc145a2f577add951f8134889b4795d47466a54a5c846d691693"
SRC_URI[block-buffer-0.9.0.sha256sum] = "4152116fd6e9dadb291ae18fc1ec3575ed6d84c29642d97890f4b4a3417297e4"
SRC_URI[block-cipher-0.7.1.sha256sum] = "fa136449e765dc7faa244561ccae839c394048667929af599b5d931ebe7b7f10"
SRC_URI[blowfish-0.5.0.sha256sum] = "91d01392750dd899a2528948d6b856afe2df508d627fc7c339868c0bd0141b4b"
SRC_URI[byteorder-1.4.3.sha256sum] = "14c189c53d098945499cdfa7ecc63567cf3886b3332b312a5b4585d8d3a6a610"
SRC_URI[cache-padded-1.2.0.sha256sum] = "c1db59621ec70f09c5e9b597b220c7a2b43611f4710dc03ceb8748637775692c"
SRC_URI[cairo-rs-0.14.9.sha256sum] = "33b5725979db0c586d98abad2193cdb612dd40ef95cd26bd99851bf93b3cb482"
SRC_URI[cairo-sys-rs-0.14.9.sha256sum] = "b448b876970834fda82ba3aeaccadbd760206b75388fc5c1b02f1e343b697570"
SRC_URI[cc-1.0.73.sha256sum] = "2fff2a6927b3bb87f9595d67196a70493f627687a71d87a0d692242c33f58c11"
SRC_URI[cfg-expr-0.8.1.sha256sum] = "b412e83326147c2bb881f8b40edfbf9905b9b8abaebd0e47ca190ba62fda8f0e"
SRC_URI[cfg-if-0.1.10.sha256sum] = "4785bdd1c96b2a846b2bd7cc02e86b6b3dbf14e7e53446c4f54c92a361040822"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.19.sha256sum] = "670ad68c9088c2a963aaa298cb369688cf3f9465ce5e2d4ca10e6e0098a1ce73"
SRC_URI[clap-2.34.0.sha256sum] = "a0610544180c38b88101fecf2dd634b174a62eef6946f84dfc6a7127512b381c"
SRC_URI[concurrent-queue-1.2.2.sha256sum] = "30ed07550be01594c6026cff2a1d7fe9c8f683caa798e12b68694ac9e88286a3"
SRC_URI[cpufeatures-0.2.2.sha256sum] = "59a6001667ab124aebae2a495118e11d30984c3a653e99d86d58971708cf5e4b"
SRC_URI[crc32fast-1.3.2.sha256sum] = "b540bd8bc810d3885c6ea91e2018302f68baba2129ab3e88f32389ee9370880d"
SRC_URI[crossbeam-channel-0.3.9.sha256sum] = "c8ec7fcd21571dc78f96cc96243cab8d8f035247c3efd16c687be154c3fa9efa"
SRC_URI[crossbeam-utils-0.6.6.sha256sum] = "04973fa96e96579258a5091af6003abde64af786b860f18622b82e026cca60e6"
SRC_URI[crypto-mac-0.8.0.sha256sum] = "b584a330336237c1eecd3e94266efb216c56ed91225d634cb2991c5f3fd1aeab"
SRC_URI[cursive-0.11.0.sha256sum] = "e50c8961fb6728e44ea668e4133ca6f5bea681cb5e93aaee70a8f452412bbce5"
SRC_URI[dbus-0.6.5.sha256sum] = "48b5f0f36f1eebe901b0e6bee369a77ed3396334bf3f09abd46454a576f71819"
SRC_URI[dbus-0.8.4.sha256sum] = "5cd9e78c210146a1860f897db03412fd5091fd73100778e43ee255cca252cf32"
SRC_URI[derivative-2.2.0.sha256sum] = "fcc3dd5e9e9c0b295d6e1e4d811fb6f157d5ffd784b8d202fc62eac8035a770b"
SRC_URI[digest-0.9.0.sha256sum] = "d3dd60d1080a57a05ab032377049e0591415d2b31afd7028356dbf3cc6dcb066"
SRC_URI[easy-parallel-3.2.0.sha256sum] = "6907e25393cdcc1f4f3f513d9aac1e840eb1cc341a0fccb01171f7d14d10b946"
SRC_URI[ed25519-1.5.2.sha256sum] = "1e9c280362032ea4203659fc489832d0204ef09f247a0506f170dafcac08c369"
SRC_URI[either-1.6.1.sha256sum] = "e78d4f1cc4ae33bbfc157ed5d5a5ef3bc29227303d595861deb238fcec4e9457"
SRC_URI[enum-map-derive-0.4.6.sha256sum] = "e5c450cf304c9e18d45db562025a14fb1ca0f5c769b6f609309f81d4c31de455"
SRC_URI[enum-map-internals-0.1.2.sha256sum] = "38b0bacf3ea7aba18ce84032efc3f0fa29f5c814048b742ab3e64d07d83ac3e8"
SRC_URI[enum-map-0.5.0.sha256sum] = "ccd9b2d5e0eb5c2ff851791e2af90ab4531b1168cfc239d1c0bf467e60ba3c89"
SRC_URI[enumflags2-0.6.4.sha256sum] = "83c8d82922337cd23a15f88b70d8e4ef5f11da38dd7cdb55e84dd5de99695da0"
SRC_URI[enumflags2_derive-0.6.4.sha256sum] = "946ee94e3dbf58fdd324f9ce245c7b238d46a66f00e86a020b71996349e46cce"
SRC_URI[enumset-0.3.19.sha256sum] = "43bd5effaae6a671efa2032056110916a501bd24128cfb6f44e5a339b5cdb152"
SRC_URI[enumset_derive-0.3.2.sha256sum] = "f73e5c77cf68e532b0e6fdd22c7f8f4d09f6f663692aecca0b3d8ec2e11af723"
SRC_URI[event-listener-2.5.2.sha256sum] = "77f3309417938f28bf8228fcff79a4a37103981e3e186d2ccd19c74b38f4eb71"
SRC_URI[failure-0.1.8.sha256sum] = "d32e9bd16cc02eae7db7ef620b392808b89f6a5e16bb3497d159c6b92a0f4f86"
SRC_URI[failure_derive-0.1.8.sha256sum] = "aa4da3c766cd7a0db8242e326e9e4e081edd567072893ed320008189715366a4"
SRC_URI[fastrand-1.7.0.sha256sum] = "c3fcf0cee53519c866c09b5de1f6c56ff9d647101f81c1964fa632e148896cdf"
SRC_URI[field-offset-0.3.4.sha256sum] = "1e1c54951450cbd39f3dbcf1005ac413b49487dabf18a720ad2383eccfeffb92"
SRC_URI[flate2-1.0.24.sha256sum] = "f82b0f4c27ad9f8bfd1f3208d882da2b09c301bc1c828fd3a00d0216d2fbbff6"
SRC_URI[futures-channel-0.3.21.sha256sum] = "c3083ce4b914124575708913bca19bfe887522d6e2e6d0952943f5eac4a74010"
SRC_URI[futures-core-0.3.21.sha256sum] = "0c09fd04b7e4073ac7156a9539b57a484a8ea920f79c7c675d05d289ab6110d3"
SRC_URI[futures-executor-0.3.21.sha256sum] = "9420b90cfa29e327d0429f19be13e7ddb68fa1cccb09d65e5706b8c7a749b8a6"
SRC_URI[futures-io-0.3.21.sha256sum] = "fc4045962a5a5e935ee2fdedaa4e08284547402885ab326734432bed5d12966b"
SRC_URI[futures-lite-1.12.0.sha256sum] = "7694489acd39452c77daa48516b894c153f192c3578d5a839b62c58099fcbf48"
SRC_URI[futures-macro-0.3.21.sha256sum] = "33c1e13800337f4d4d7a316bf45a567dbcb6ffe087f16424852d97e97a91f512"
SRC_URI[futures-sink-0.3.21.sha256sum] = "21163e139fa306126e6eedaf49ecdb4588f939600f0b1e770f4205ee4b7fa868"
SRC_URI[futures-task-0.3.21.sha256sum] = "57c66a976bf5909d801bbef33416c41372779507e7a6b3a5e25e4749c58f776a"
SRC_URI[futures-util-0.3.21.sha256sum] = "d8b7abd5d659d9b90c8cba917f6ec750a74e2dc23902ef9cd4cc8c8b22e6036a"
SRC_URI[gdk-pixbuf-sys-0.14.0.sha256sum] = "f097c0704201fbc8f69c1762dc58c6947c8bb188b8ed0bc7e65259f1894fe590"
SRC_URI[gdk-pixbuf-0.14.0.sha256sum] = "534192cb8f01daeb8fab2c8d4baa8f9aae5b7a39130525779f5c2608e235b10f"
SRC_URI[gdk-sys-0.14.0.sha256sum] = "0e091b3d3d6696949ac3b3fb3c62090e5bfd7bd6850bef5c3c5ea701de1b1f1e"
SRC_URI[gdk-0.14.3.sha256sum] = "b9d749dcfc00d8de0d7c3a289e04a04293eb5ba3d8a4e64d64911d481fa9933b"
SRC_URI[generic-array-0.14.5.sha256sum] = "fd48d33ec7f05fbfa152300fdad764757cbded343c1aa1cff2fbaf4134851803"
SRC_URI[getrandom-0.1.16.sha256sum] = "8fc3cb4d91f53b50155bdcfd23f6a4c39ae1969c2ae85982b135750cccaf5fce"
SRC_URI[getrandom-0.2.6.sha256sum] = "9be70c98951c83b8d2f8f60d7065fa6d5146873094452a1008da8c2f1e4205ad"
SRC_URI[gimli-0.26.1.sha256sum] = "78cc372d058dcf6d5ecd98510e7fbc9e5aec4d21de70f65fea8fecebcd881bd4"
SRC_URI[gio-sys-0.14.0.sha256sum] = "c0a41df66e57fcc287c4bcf74fc26b884f31901ea9792ec75607289b456f48fa"
SRC_URI[gio-0.14.8.sha256sum] = "711c3632b3ebd095578a9c091418d10fed492da9443f58ebc8f45efbeb215cb0"
SRC_URI[glib-macros-0.10.1.sha256sum] = "41486a26d1366a8032b160b59065a59fb528530a46a49f627e7048fb8c064039"
SRC_URI[glib-macros-0.14.1.sha256sum] = "2aad66361f66796bfc73f530c51ef123970eb895ffba991a234fcf7bea89e518"
SRC_URI[glib-sys-0.10.1.sha256sum] = "c7e9b997a66e9a23d073f2b1abb4dbfc3925e0b8952f67efd8d9b6e168e4cdc1"
SRC_URI[glib-sys-0.14.0.sha256sum] = "1c1d60554a212445e2a858e42a0e48cece1bd57b311a19a9468f70376cf554ae"
SRC_URI[glib-0.10.3.sha256sum] = "0c685013b7515e668f1b57a165b009d4d28cb139a8a989bbd699c10dad29d0c5"
SRC_URI[glib-0.14.8.sha256sum] = "7c515f1e62bf151ef6635f528d05b02c11506de986e43b34a5c920ef0b3796a4"
SRC_URI[gobject-sys-0.10.0.sha256sum] = "952133b60c318a62bf82ee75b93acc7e84028a093e06b9e27981c2b6fe68218c"
SRC_URI[gobject-sys-0.14.0.sha256sum] = "aa92cae29759dae34ab5921d73fff5ad54b3d794ab842c117e36cafc7994c3f5"
SRC_URI[gtk-sys-0.14.0.sha256sum] = "8c14c8d3da0545785a7c5a120345b3abb534010fb8ae0f2ef3f47c027fba303e"
SRC_URI[gtk-0.14.3.sha256sum] = "2eb51122dd3317e9327ec1e4faa151d1fa0d95664cd8fb8dcfacf4d4d29ac70c"
SRC_URI[gtk3-macros-0.14.0.sha256sum] = "21de1da96dc117443fb03c2e270b2d34b7de98d0a79a19bbb689476173745b79"
SRC_URI[heck-0.3.3.sha256sum] = "6d621efb26863f0e9924c6ac577e8275e5e6b77455db64ffa6c65c904e9e132c"
SRC_URI[hermit-abi-0.1.19.sha256sum] = "62b467343b94ba476dcb2500d242dadbb39557df889310ac77c5d99100aaac33"
SRC_URI[hex-0.4.3.sha256sum] = "7f24254aa9a54b5c858eaee2f5bccdb46aaf0e486a595ed5fd8f86ba55232a70"
SRC_URI[hmac-0.8.1.sha256sum] = "126888268dcc288495a26bf004b38c5fdbb31682f992c84ceb046a1f0fe38840"
SRC_URI[inotify-sys-0.1.5.sha256sum] = "e05c02b5e89bff3b946cedeca278abc628fe811e604f027c45a8aa3cf793d0eb"
SRC_URI[inotify-0.8.3.sha256sum] = "46dd0a94b393c730779ccfd2a872b67b1eb67be3fc33082e733bdb38b5fde4d4"
SRC_URI[instant-0.1.12.sha256sum] = "7a5bbe824c507c5da5956355e86a746d82e0e1464f65d862cc5e71da70e94b2c"
SRC_URI[itertools-0.10.3.sha256sum] = "a9a9d19fa1e79b6215ff29b9d6880b706147f16e9b1dbb1e4e5947b5b02bc5e3"
SRC_URI[itertools-0.9.0.sha256sum] = "284f18f85651fe11e8a991b2adb42cb078325c996ed026d994719efcfca1d54b"
SRC_URI[lazy_static-1.4.0.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[libc-0.2.126.sha256sum] = "349d5a591cd28b49e1d1037471617a32ddcda5731b99419008085f72d5a53836"
SRC_URI[libdbus-sys-0.2.2.sha256sum] = "c185b5b7ad900923ef3a8ff594083d4d9b5aea80bb4f32b8342363138c0d456b"
SRC_URI[libsodium-sys-0.2.7.sha256sum] = "6b779387cd56adfbc02ea4a668e704f729be8d6a6abd2c27ca5ee537849a92fd"
SRC_URI[log-0.4.17.sha256sum] = "abb12e687cfb44aa40f41fc3978ef76448f9b6038cad6aef4259d3c095a2382e"
SRC_URI[md-5-0.9.1.sha256sum] = "7b5a279bb9607f9f53c22d496eade00d138d1bdcccd07d74650387cf94942a15"
SRC_URI[memchr-2.5.0.sha256sum] = "2dffe52ecf27772e601905b7522cb4ef790d2cc203488bbd0e2fe85fcb74566d"
SRC_URI[memoffset-0.6.5.sha256sum] = "5aa361d4faea93603064a027415f07bd8e1d5c88c9fbf68bf56a285428fd79ce"
SRC_URI[miniz_oxide-0.5.1.sha256sum] = "d2b29bd4bc3f33391105ebee3589c19197c4271e3e5a9ec9bfe8127eeff8f082"
SRC_URI[nix-0.17.0.sha256sum] = "50e4785f2c3b7589a0d0c1dd60285e1188adac4006e8abd6dd578e1567027363"
SRC_URI[nix-0.21.2.sha256sum] = "77d9f3521ea8e0641a153b3cddaf008dcbf26acd4ed739a2517295e0760d12c7"
SRC_URI[num-complex-0.2.4.sha256sum] = "b6b19411a9719e753aff12e5187b74d60d3dc449ec3f4dc21e3989c3f554bc95"
SRC_URI[num-integer-0.1.45.sha256sum] = "225d3389fb3509a24c93f5c29eb6bde2586b98d9f016636dff58d7c6f7569cd9"
SRC_URI[num-iter-0.1.43.sha256sum] = "7d03e6c028c5dc5cac6e2dec0efda81fc887605bb3d884578bb6d6bf7514e252"
SRC_URI[num-rational-0.2.4.sha256sum] = "5c000134b5dbf44adc5cb772486d335293351644b801551abe8f75c84cfa4aef"
SRC_URI[num-traits-0.2.15.sha256sum] = "578ede34cf02f8924ab9447f50c28075b4d3e5b269972345e7e0372b38c6cdcd"
SRC_URI[num-0.2.1.sha256sum] = "b8536030f9fea7127f841b45bb6243b27255787fb4eb83958aa1ef9d2fdc0c36"
SRC_URI[numtoa-0.1.0.sha256sum] = "b8f8bdf33df195859076e54ab11ee78a1b208382d3a26ec40d142ffc1ecc49ef"
SRC_URI[object-0.28.4.sha256sum] = "e42c982f2d955fac81dd7e1d0e1426a7d702acd9c98d19ab01083a6a0328c424"
SRC_URI[once_cell-1.10.0.sha256sum] = "87f3e037eac156d1775da914196f0f37741a274155e34a0b7e427c35d2a2ecb9"
SRC_URI[opaque-debug-0.2.3.sha256sum] = "2839e79665f131bdb5782e51f2c6c9599c133c6098982a54c794358bf432529c"
SRC_URI[opaque-debug-0.3.0.sha256sum] = "624a8340c38c1b80fd549087862da4ba43e08858af025b236e509b6649fc13d5"
SRC_URI[owning_ref-0.4.1.sha256sum] = "6ff55baddef9e4ad00f88b6c743a2a8062d4c6ade126c2a528644b8e444d52ce"
SRC_URI[pango-sys-0.10.0.sha256sum] = "24d2650c8b62d116c020abd0cea26a4ed96526afda89b1c4ea567131fdefc890"
SRC_URI[pango-sys-0.14.0.sha256sum] = "2367099ca5e761546ba1d501955079f097caa186bb53ce0f718dca99ac1942fe"
SRC_URI[pango-0.14.8.sha256sum] = "546fd59801e5ca735af82839007edd226fe7d3bb06433ec48072be4439c28581"
SRC_URI[pango-0.9.1.sha256sum] = "9937068580bebd8ced19975938573803273ccbcbd598c58d4906efd4ac87c438"
SRC_URI[parking-2.0.0.sha256sum] = "427c3892f9e783d91cc128285287e70a59e206ca452770ece88a76f7a3eddd72"
SRC_URI[pest-2.1.3.sha256sum] = "10f4872ae94d7b90ae48754df22fd42ad52ce740b8f370b03da4835417403e53"
SRC_URI[pin-project-lite-0.2.9.sha256sum] = "e0a7ae3ac2f1173085d398531c705756c94a4c56843785df85a60c1a0afac116"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[pkg-config-0.3.25.sha256sum] = "1df8c4ec4b0627e53bdf214615ad287367e482558cf84b109250b37464dc03ae"
SRC_URI[polling-2.2.0.sha256sum] = "685404d509889fade3e86fe3a5803bca2ec09b0c0778d5ada6ec8bf7a8de5259"
SRC_URI[posix-acl-1.0.0.sha256sum] = "2ea5dae99e4365fa738533b43f4c649c0450ba7fbb81a984a4fba6a42ce91812"
SRC_URI[ppv-lite86-0.2.16.sha256sum] = "eb9f9e6e233e5c4a35559a617bf40a4ec447db2e84c20b55a6f83167b7e57872"
SRC_URI[proc-macro-crate-0.1.5.sha256sum] = "1d6ea3c4595b96363c13943497db34af4460fb474a95c43f4446ad341b8c9785"
SRC_URI[proc-macro-crate-1.1.3.sha256sum] = "e17d47ce914bf4de440332250b0edd23ce48c005f59fab39d3335866b114f11a"
SRC_URI[proc-macro-error-attr-1.0.4.sha256sum] = "a1be40180e52ecc98ad80b184934baf3d0d29f979574e439af5a55274b35f869"
SRC_URI[proc-macro-error-1.0.4.sha256sum] = "da25490ff9892aab3fcf7c36f08cfb902dd3e71ca0f9f9517bea02a73a5ce38c"
SRC_URI[proc-macro2-0.4.30.sha256sum] = "cf3d2011ab5c909338f7887f4fc896d35932e29146c12c8d01da6b22a80ba759"
SRC_URI[proc-macro2-1.0.39.sha256sum] = "c54b25569025b7fc9651de43004ae593a75ad88543b17178aa5e1b9c4f15f56f"
SRC_URI[procfs-0.12.0.sha256sum] = "0941606b9934e2d98a3677759a971756eb821f75764d0e0d26946d08e74d9104"
SRC_URI[pwhash-0.3.1.sha256sum] = "1068eebd5d8aa4bbd6cbba05ff2647ad32f8ec86a3b73417b95522383c4bd18f"
SRC_URI[quote-0.6.13.sha256sum] = "6ce23b6b870e8f94f81fb0a363d65d86675884b34a09043c81e5562f11c1f8e1"
SRC_URI[quote-1.0.18.sha256sum] = "a1feb54ed693b93a84e14094943b84b7c4eae204c512b7ccb95ab0c66d278ad1"
SRC_URI[rand-0.7.3.sha256sum] = "6a6b1679d49b24bbfe0c803429aa1874472f50d9b363131f0e89fc356b544d03"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha-0.2.2.sha256sum] = "f4c8ed856279c9737206bf725bf36935d8666ead7aa69b52be55af369d193402"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core-0.5.1.sha256sum] = "90bde5296fc891b0cef12a6d03ddccc162ce7b2aff54160af9338f8d40df6d19"
SRC_URI[rand_core-0.6.3.sha256sum] = "d34f1408f55294453790c48b2f1ebbb1c5b4b7563eb1f418bcfcfdbb06ebb4e7"
SRC_URI[rand_hc-0.2.0.sha256sum] = "ca3129af7b92a17112d59ad498c6f81eaf463253766b90396d39ea7a39d6613c"
SRC_URI[redox_syscall-0.2.13.sha256sum] = "62f25bc4c7e55e0b0b7a1d43fb893f4fa1361d0abe38b9ce4f323c2adfe6ef42"
SRC_URI[redox_termios-0.1.2.sha256sum] = "8440d8acb4fd3d277125b4bd01a6f38aee8d814b3b5fc09b3f2b825d37d3fe8f"
SRC_URI[regex-syntax-0.6.25.sha256sum] = "f497285884f3fcff424ffc933e56d7cbca511def0c9831a7f9b5f6153e3cc89b"
SRC_URI[regex-1.5.5.sha256sum] = "1a11647b6b25ff05a515cb92c365cec08801e83423a235b51e231e1808747286"
SRC_URI[remove_dir_all-0.5.3.sha256sum] = "3acd125665422973a33ac9d3dd2df85edad0f4ae9b00dafb1a05e43a9f5ef8e7"
SRC_URI[rpassword-4.0.5.sha256sum] = "99371657d3c8e4d816fb6221db98fa408242b0b53bac08f8676a41f8554fe99f"
SRC_URI[rustc-demangle-0.1.21.sha256sum] = "7ef03e0a2b150c7a90d01faf6254c9c48a41e95fb2a8c2ac1c6f0d2b9aefc342"
SRC_URI[rustc_version-0.3.3.sha256sum] = "f0dfe2087c51c460008730de8b57e6a320782fbfb312e1f4d520e6c6fae155ee"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[scoped-tls-1.0.0.sha256sum] = "ea6a9290e3c9cf0f18145ef7ffa62d68ee0bf5fcd651017e586dc7fd5da448c2"
SRC_URI[semver-parser-0.10.2.sha256sum] = "00b0bef5b7f9e0df16536d3961cfb6e84331c065b4066afb39768d0e319411f7"
SRC_URI[semver-0.11.0.sha256sum] = "f301af10236f6df4160f7c3f04eec6dbc70ace82d23326abad5edee88801c6b6"
SRC_URI[serde-1.0.137.sha256sum] = "61ea8d54c77f8315140a05f4c7237403bf38b72704d031543aa1d16abbf517d1"
SRC_URI[serde_derive-1.0.137.sha256sum] = "1f26faba0c3959972377d3b2d306ee9f71faee9714294e41bb777f83f88578be"
SRC_URI[serde_repr-0.1.8.sha256sum] = "a2ad84e47328a31223de7fed7a4f5087f2d6ddfe586cf3ca25b7a165bc0a5aed"
SRC_URI[sha-1-0.9.8.sha256sum] = "99cd6713db3cf16b6c84e06321e049a9b9f699826e16096d23bbcc44d15d51a6"
SRC_URI[sha1-0.6.1.sha256sum] = "c1da05c97445caa12d05e848c4a4fcbbea29e748ac28f7e80e9b010392063770"
SRC_URI[sha1_smol-1.0.0.sha256sum] = "ae1a47186c03a32177042e55dbc5fd5aee900b8e0069a8d70fba96a9375cd012"
SRC_URI[sha2-0.9.9.sha256sum] = "4d58a1e1bf39749807d89cf2d98ac2dfa0ff1cb3faa38fbb64dd88ac8013d800"
SRC_URI[signal-hook-registry-1.4.0.sha256sum] = "e51e73328dc4ac0c7ccbda3a494dfa03df1de2f46018127f60c693f2648455b0"
SRC_URI[signal-hook-0.1.17.sha256sum] = "7e31d442c16f047a671b5a71e2161d6e68814012b7f5379d269ebd915fac2729"
SRC_URI[signature-1.5.0.sha256sum] = "f054c6c1a6e95179d6f23ed974060dcefb2d9388bb7256900badad682c499de4"
SRC_URI[slab-0.4.6.sha256sum] = "eb703cfe953bccee95685111adeedb76fabe4e97549a58d16f03ea7b9367bb32"
SRC_URI[slotmap-1.0.6.sha256sum] = "e1e08e261d0e8f5c43123b7adf3e4ca1690d655377ac93a03b2c9d3e98de1342"
SRC_URI[smallvec-1.8.0.sha256sum] = "f2dd574626839106c320a323308629dcb1acfc96e32a8cba364ddc61ac23ee83"
SRC_URI[socket2-0.4.4.sha256sum] = "66d72b759436ae32898a2af0a14218dbf55efde3feeb170eb623637db85ee1e0"
SRC_URI[sodiumoxide-0.2.7.sha256sum] = "e26be3acb6c2d9a7aac28482586a7856436af4cfe7100031d219de2d2ecb0028"
SRC_URI[stable_deref_trait-1.2.0.sha256sum] = "a8f112729512f8e442d81f95a8a7ddf2b7c6b8a1a6f509a95864142b30cab2d3"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[strsim-0.8.0.sha256sum] = "8ea5119cdb4c55b55d432abb513a0429384878c15dde60cc77b1c99de1a95a6a"
SRC_URI[strum-0.18.0.sha256sum] = "57bd81eb48f4c437cadc685403cad539345bf703d78e63707418431cecd4522b"
SRC_URI[strum-0.21.0.sha256sum] = "aaf86bbcfd1fa9670b7a129f64fc0c9fcbbfe4f1bc4210e9e98fe71ffc12cde2"
SRC_URI[strum_macros-0.18.0.sha256sum] = "87c85aa3f8ea653bfd3ddf25f7ee357ee4d204731f6aa9ad04002306f6e2774c"
SRC_URI[strum_macros-0.21.1.sha256sum] = "d06aaeeee809dbc59eb4556183dd927df67db1540de5be8d3ec0b6636358a5ec"
SRC_URI[subtle-2.4.1.sha256sum] = "6bdef32e8150c2a081110b42772ffe7d7c9032b606bc226c8260fd97e0976601"
SRC_URI[syn-0.15.44.sha256sum] = "9ca4b3b69a77cbe1ffc9e198781b7acb0c7365a883670e8f1c1bc66fba79a5c5"
SRC_URI[syn-1.0.95.sha256sum] = "fbaf6116ab8924f39d52792136fb74fd60a80194cf1b1c6ffa6453eef1c3f942"
SRC_URI[synstructure-0.12.6.sha256sum] = "f36bdaa60a83aca3921b5259d5400cbf5e90fc51931376a9bd4a0eb79aa7210f"
SRC_URI[system-deps-1.3.2.sha256sum] = "0f3ecc17269a19353b3558b313bba738b25d82993e30d62a18406a24aba4649b"
SRC_URI[system-deps-3.2.0.sha256sum] = "480c269f870722b3b08d2f13053ce0c2ab722839f472863c3e2d61ff3a1c2fa6"
SRC_URI[tempfile-3.3.0.sha256sum] = "5cdb1ef4eaeeaddc8fbd371e5017057064af0911902ef36b39801f67cc6d79e4"
SRC_URI[termion-1.5.6.sha256sum] = "077185e2eac69c3f8379a4298e1e07cd36beb962290d4a51199acf0fdc10607e"
SRC_URI[textwrap-0.11.0.sha256sum] = "d326610f408c7a4eb6f51c37c330e496b08506c9457c9d34287ecc38809fb060"
SRC_URI[thiserror-impl-1.0.31.sha256sum] = "0396bc89e626244658bef819e22d0cc459e795a5ebe878e6ec336d1674a8d79a"
SRC_URI[thiserror-1.0.31.sha256sum] = "bd829fe32373d27f76265620b5309d0340cb8550f523c1dda251d6298069069a"
SRC_URI[time-0.1.43.sha256sum] = "ca8a50ef2360fbd1eeb0ecd46795a87a19024eb4b53c5dc916ca1fd95fe62438"
SRC_URI[toml-0.4.10.sha256sum] = "758664fc71a3a69038656bee8b6be6477d2a6c315a6b81f7081f591bffa4111f"
SRC_URI[toml-0.5.9.sha256sum] = "8d82e1a7758622a465f8cee077614c73484dac5b836c02ff6a40d5d1010324d7"
SRC_URI[typenum-1.15.0.sha256sum] = "dcf81ac59edc17cc8697ff311e8f5ef2d99fcbd9817b34cec66f90b6c3dfd987"
SRC_URI[ucd-trie-0.1.3.sha256sum] = "56dee185309b50d1f11bfedef0fe6d036842e3fb77413abef29f8f8d1c5d4c1c"
SRC_URI[unicode-ident-1.0.0.sha256sum] = "d22af068fba1eb5edcb4aea19d382b2a3deb4c8f9d475c589b6ada9e0fd493ee"
SRC_URI[unicode-segmentation-1.9.0.sha256sum] = "7e8820f5d777f6224dc4be3632222971ac30164d4a258d595640799554ebfd99"
SRC_URI[unicode-width-0.1.9.sha256sum] = "3ed742d4ea2bd1176e236172c8429aaf54486e7ac098db29ffe6529e0ce50973"
SRC_URI[unicode-xid-0.1.0.sha256sum] = "fc72304796d0818e357ead4e000d19c9c174ab23dc11093ac919054d20a6a7fc"
SRC_URI[unicode-xid-0.2.3.sha256sum] = "957e51f3646910546462e67d5f7599b9e4fb8acdd304b087a6494730f9eebf04"
SRC_URI[vec_map-0.8.2.sha256sum] = "f1bddf1187be692e79c5ffeab891132dfb0f236ed36a43c7ed39f1165ee20191"
SRC_URI[version-compare-0.0.10.sha256sum] = "d63556a25bae6ea31b52e640d7c41d1ab27faba4ccb600013837a3d0b3994ca1"
SRC_URI[version-compare-0.0.11.sha256sum] = "1c18c859eead79d8b95d09e4678566e8d70105c4e7b251f707a03df32442661b"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"
SRC_URI[void-1.0.2.sha256sum] = "6a02e4885ed3bc0f2de90ea6dd45ebcbb66dacffe03547fadbb0eeae2770887d"
SRC_URI[waker-fn-1.1.0.sha256sum] = "9d5b2c62b4012a3e1eca5a7e077d13b3bf498c4073e33ccd58626607748ceeca"
SRC_URI[walkdir-2.3.2.sha256sum] = "808cf2735cd4b6866113f648b791c6adc5714537bc222d9347bb203386ffda56"
SRC_URI[wasi-0.10.2+wasi-snapshot-preview1.sha256sum] = "fd6fbd9a79829dd1ad0cc20627bf1ed606756a7f77edff7b66b7064f9cb327c6"
SRC_URI[wasi-0.9.0+wasi-snapshot-preview1.sha256sum] = "cccddf32554fecc6acb585f82a32a72e28b48f8c4c1883ddfeeeaa96f7d8e519"
SRC_URI[wepoll-ffi-0.1.2.sha256sum] = "d743fdedc5c64377b5fc2bc036b01c7fd642205a0d96356034ae3404d49eb7fb"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.5.sha256sum] = "70ec6ce85bb158151cae5e5c87f95a8e97d2c0c4b001223f33a334e3ce5de178"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[xi-unicode-0.1.0.sha256sum] = "12ea8eda4b1eb72f02d148402e23832d56a33f55d8c1b2d5bcdde91d79d47cb1"
SRC_URI[zbus-2.0.0-beta.5.sha256sum] = "d45f4720326304c291f96f66b6c1131f16964bba6bffe216ac85de2e48321a10"
SRC_URI[zbus_macros-2.0.0-beta.5.sha256sum] = "cf0fa91321143695013cb3fa62a6395dbe14eafd97ab58c2ba73f61d5035b1d9"
SRC_URI[zvariant-2.10.0.sha256sum] = "a68c7b55f2074489b7e8e07d2d0a6ee6b4f233867a653c664d8020ba53692525"
SRC_URI[zvariant_derive-2.10.0.sha256sum] = "e4ca5e22593eb4212382d60d26350065bf2a02c34b85bc850474a74b589a3de9"

export SODIUM_USE_PKG_CONFIG = "1"

DEPENDS = "libsodium openssl dbus gtk+3 glib-2.0 acl"
BBCLASSEXTEND = "native"
PACKAGES =+ "${PN}-realms ${PN}-tools ${PN}-mkimage ${PN}-boot"

FILES:${PN}-realms = "${bindir}/realms"
FILES:${PN}-mkimage = "${bindir}/citadel-mkimage"
FILES:${PN}-boot = "${libexecdir}/citadel-boot"

FILES:${PN} = "\
    ${libexecdir}/citadel-tool \
    ${libexecdir}/citadel-boot \
    ${libexecdir}/citadel-run \
    ${libexecdir}/citadel-install \
    ${libexecdir}/citadel-install-backend \
    ${libexecdir}/citadel-desktop-sync \
    ${libexecdir}/citadel-realmsd \
    ${libexecdir}/citadel-installer-ui \
    ${libexecdir}/realm-config-ui \
    ${bindir}/citadel-image \
    ${bindir}/citadel-realmfs \
    ${bindir}/citadel-update \
    ${systemd_system_unitdir} \
    ${sysconfdir}/dbus-1/system.d \
    ${datadir}/applications \
"

SYSTEMD_SERVICE:${PN} = "citadel-current-watcher.path citadel-realmsd.service citadel-boot-automount.service"

TARGET_BIN = "${B}/target/${CARGO_TARGET_SUBDIR}"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${libexecdir}
    install -d ${D}${systemd_system_unitdir}
    install -d ${D}${datadir}/applications

    # Services desktop sync
    install -m 644 ${S}/systemd/citadel-desktop-watcher.path ${D}${systemd_system_unitdir}
    install -m 644 ${S}/systemd/citadel-desktop-watcher.service ${D}${systemd_system_unitdir}
    install -m 644 ${S}/systemd/citadel-current-watcher.path ${D}${systemd_system_unitdir}
    install -m 644 ${S}/systemd/citadel-current-watcher.service ${D}${systemd_system_unitdir}

    # Unit to run: citadel-boot boot-automount
    install -m 644 ${S}/systemd/citadel-boot-automount.service ${D}${systemd_system_unitdir}

    # realmsd
    install -m 644 ${S}/data/citadel-realmsd.service ${D}${systemd_system_unitdir}
    install -m 755 -T ${TARGET_BIN}/realmsd ${D}${libexecdir}/citadel-realmsd
    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 644 ${S}/data/com.subgraph.realms.Manager.conf ${D}${sysconfdir}/dbus-1/system.d

    # citadel-installer-ui
    install -m 755 ${TARGET_BIN}/citadel-installer-ui ${D}${libexecdir}
    install -m 644 ${S}/data/com.subgraph.installer.Manager.conf ${D}${sysconfdir}/dbus-1/system.d

    # realm-config-ui
    install -m 0755 ${TARGET_BIN}/realm-config-ui ${D}${libexecdir}
    install -m 0644 ${S}/data/com.subgraph.RealmConfig.desktop ${D}${datadir}/applications

    # /usr/libexec/citadel-tool
    install -m 755 ${TARGET_BIN}/citadel-tool ${D}${libexecdir}

    # citadel-realms as /usr/bin/realms
    install -m 755 -T ${TARGET_BIN}/citadel-realms ${D}${bindir}/realms

    ln ${D}${libexecdir}/citadel-tool ${D}${libexecdir}/citadel-boot
    ln ${D}${libexecdir}/citadel-tool ${D}${libexecdir}/citadel-install
    ln ${D}${libexecdir}/citadel-tool ${D}${libexecdir}/citadel-install-backend
    ln ${D}${libexecdir}/citadel-tool ${D}${libexecdir}/citadel-desktop-sync
    ln ${D}${libexecdir}/citadel-tool ${D}${libexecdir}/citadel-run
    ln ${D}${libexecdir}/citadel-tool ${D}${bindir}/citadel-image
    ln ${D}${libexecdir}/citadel-tool ${D}${bindir}/citadel-mkimage
    ln ${D}${libexecdir}/citadel-tool ${D}${bindir}/citadel-realmfs
    ln ${D}${libexecdir}/citadel-tool ${D}${bindir}/citadel-update
}

#
# To make development more convenient citadel-tools recipes support
# building from a checked out tree on the filesystem. If the variable
# CITADEL_TOOLS_PATH is set (preferably in build/conf/local.conf) then
# bitbake will not check out the source files from git but instead will
# copy the directory this variable contains.
#

#
#
# By default:
#
#     S = "${WORKDIR}/git"
#
# if CITADEL_TOOLS_PATH is set:
#
#     S = "${WORKDIR}${CITADEL_TOOLS_PATH}"
#
S = "${WORKDIR}${@source_path(d)}"

#
# By default:
#
#     SRC_URI += "${GIT_URI}"
#
# If CITADEL_TOOLS_PATH is set:
#
#     SRC_URI += "file://${CITADEL_TOOLS_PATH}"
#
SRC_URI += "${@source_uri(d)}"

def source_path(d):
    tools_path = d.getVar("CITADEL_TOOLS_PATH")

    if tools_path:
        return tools_path
    else:
        return "/git"

def source_uri(d):
    tools_path = d.getVar("CITADEL_TOOLS_PATH")
    if tools_path:
        return "file://" + tools_path
    else:
        return d.getVar("GIT_URI")

# Set debug build if CITADEL_TOOLS_PATH is set for faster builds
DEBUG_BUILD = "${@debug_build(d)}"
def debug_build(d):
    tools_path = d.getVar("CITADEL_TOOLS_PATH")
    if tools_path:
        return "1"
    else:
        return "0"

#do_fetch[file-checksums] = ""
