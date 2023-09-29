SUMMARY = "${PN}"
HOMEPAGE = "http://github.com/subgraph/citadel"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM=""

inherit cargo systemd pkgconfig
#
# Update this when changes are pushed to github
#
SRCREV = "32b4b0886a2a1872b4b7a2d36236daf0b94578d6"

SRC_URI = "git://github.com/subgraph/sgmenu.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

# If Cargo.lock changes in citadel-tools, this needs to be updated.
# cargo bitbake does not support workspaces so as a workaround first
# copy the Cargo.lock file into one of the tool subdirectories. In
# that subdirectory run "cargo bitbake" and it will produce a bitbake
# recipe file with the correct set of dependencies for the Cargo.lock
# file.  Copy just the SRC_URI variable from that file here to update
# the dependency list.

SRC_URI += " \
crate://crates.io/aho-corasick/0.7.13 \
crate://crates.io/anyhow/1.0.31 \
crate://crates.io/atk/0.9.0 \
crate://crates.io/atk-sys/0.10.0 \
crate://crates.io/atty/0.2.14 \
crate://crates.io/bitflags/1.2.1 \
crate://crates.io/cairo-rs/0.9.1 \
crate://crates.io/cairo-sys-rs/0.10.0 \
crate://crates.io/cc/1.0.58 \
crate://crates.io/cfg-if/0.1.10 \
crate://crates.io/either/1.5.3 \
crate://crates.io/env_logger/0.7.1 \
crate://crates.io/futures/0.3.5 \
crate://crates.io/futures-channel/0.3.5 \
crate://crates.io/futures-core/0.3.5 \
crate://crates.io/futures-executor/0.3.5 \
crate://crates.io/futures-io/0.3.5 \
crate://crates.io/futures-macro/0.3.5 \
crate://crates.io/futures-sink/0.3.5 \
crate://crates.io/futures-task/0.3.5 \
crate://crates.io/futures-util/0.3.5 \
crate://crates.io/gdk/0.13.2 \
crate://crates.io/gdk-pixbuf/0.9.0 \
crate://crates.io/gdk-pixbuf-sys/0.10.0 \
crate://crates.io/gdk-sys/0.10.0 \
crate://crates.io/gio/0.9.1 \
crate://crates.io/gio-sys/0.10.1 \
crate://crates.io/glib/0.10.3 \
crate://crates.io/glib-macros/0.10.1 \
crate://crates.io/glib-sys/0.10.1 \
crate://crates.io/gobject-sys/0.10.0 \
crate://crates.io/gtk/0.9.2 \
crate://crates.io/gtk-sys/0.10.0 \
crate://crates.io/heck/0.3.1 \
crate://crates.io/hermit-abi/0.1.15 \
crate://crates.io/humantime/1.3.0 \
crate://crates.io/itertools/0.9.0 \
crate://crates.io/lazy_static/1.4.0 \
crate://crates.io/libc/0.2.72 \
crate://crates.io/log/0.4.11 \
crate://crates.io/memchr/2.3.3 \
crate://crates.io/once_cell/1.4.0 \
crate://crates.io/pango/0.9.1 \
crate://crates.io/pango-sys/0.10.0 \
crate://crates.io/pin-project/0.4.22 \
crate://crates.io/pin-project-internal/0.4.22 \
crate://crates.io/pin-utils/0.1.0 \
crate://crates.io/pkg-config/0.3.17 \
crate://crates.io/proc-macro2/1.0.18 \
crate://crates.io/proc-macro-crate/0.1.5 \
crate://crates.io/proc-macro-error/1.0.3 \
crate://crates.io/proc-macro-error-attr/1.0.3 \
crate://crates.io/proc-macro-hack/0.5.16 \
crate://crates.io/proc-macro-nested/0.1.6 \
crate://crates.io/quick-error/1.2.3 \
crate://crates.io/quote/1.0.7 \
crate://crates.io/regex/1.3.9 \
crate://crates.io/regex-syntax/0.6.18 \
crate://crates.io/serde/1.0.114 \
crate://crates.io/slab/0.4.2 \
crate://crates.io/strum/0.18.0 \
crate://crates.io/strum_macros/0.18.0 \
crate://crates.io/syn/1.0.33 \
crate://crates.io/syn-mid/0.5.0 \
crate://crates.io/system-deps/1.3.2 \
crate://crates.io/termcolor/1.1.0 \
crate://crates.io/thiserror/1.0.20 \
crate://crates.io/thiserror-impl/1.0.20 \
crate://crates.io/thread_local/1.0.1 \
crate://crates.io/toml/0.5.6 \
crate://crates.io/unicode-segmentation/1.6.0 \
crate://crates.io/unicode-xid/0.2.1 \
crate://crates.io/version_check/0.9.2 \
crate://crates.io/version-compare/0.0.10 \
crate://crates.io/winapi/0.3.9 \
crate://crates.io/winapi-util/0.1.5 \
crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
"

SRC_URI[aho-corasick-0.7.13.sha256sum] = "043164d8ba5c4c3035fec9bbee8647c0261d788f3474306f93bb65901cae0e86"
SRC_URI[anyhow-1.0.31.sha256sum] = "85bb70cc08ec97ca5450e6eba421deeea5f172c0fc61f78b5357b2a8e8be195f"
SRC_URI[atk-0.9.0.sha256sum] = "812b4911e210bd51b24596244523c856ca749e6223c50a7fbbba3f89ee37c426"
SRC_URI[atk-sys-0.10.0.sha256sum] = "f530e4af131d94cc4fa15c5c9d0348f0ef28bac64ba660b6b2a1cf2605dedfce"
SRC_URI[atty-0.2.14.sha256sum] = "d9b39be18770d11421cdb1b9947a45dd3f37e93092cbf377614828a319d5fee8"
SRC_URI[bitflags-1.2.1.sha256sum] = "cf1de2fe8c75bc145a2f577add951f8134889b4795d47466a54a5c846d691693"
SRC_URI[cairo-rs-0.9.1.sha256sum] = "c5c0f2e047e8ca53d0ff249c54ae047931d7a6ebe05d00af73e0ffeb6e34bdb8"
SRC_URI[cairo-sys-rs-0.10.0.sha256sum] = "2ed2639b9ad5f1d6efa76de95558e11339e7318426d84ac4890b86c03e828ca7"
SRC_URI[cc-1.0.58.sha256sum] = "f9a06fb2e53271d7c279ec1efea6ab691c35a2ae67ec0d91d7acec0caf13b518"
SRC_URI[cfg-if-0.1.10.sha256sum] = "4785bdd1c96b2a846b2bd7cc02e86b6b3dbf14e7e53446c4f54c92a361040822"
SRC_URI[either-1.5.3.sha256sum] = "bb1f6b1ce1c140482ea30ddd3335fc0024ac7ee112895426e0a629a6c20adfe3"
SRC_URI[env_logger-0.7.1.sha256sum] = "44533bbbb3bb3c1fa17d9f2e4e38bbbaf8396ba82193c4cb1b6445d711445d36"
SRC_URI[futures-0.3.5.sha256sum] = "1e05b85ec287aac0dc34db7d4a569323df697f9c55b99b15d6b4ef8cde49f613"
SRC_URI[futures-channel-0.3.5.sha256sum] = "f366ad74c28cca6ba456d95e6422883cfb4b252a83bed929c83abfdbbf2967d5"
SRC_URI[futures-core-0.3.5.sha256sum] = "59f5fff90fd5d971f936ad674802482ba441b6f09ba5e15fd8b39145582ca399"
SRC_URI[futures-executor-0.3.5.sha256sum] = "10d6bb888be1153d3abeb9006b11b02cf5e9b209fda28693c31ae1e4e012e314"
SRC_URI[futures-io-0.3.5.sha256sum] = "de27142b013a8e869c14957e6d2edeef89e97c289e69d042ee3a49acd8b51789"
SRC_URI[futures-macro-0.3.5.sha256sum] = "d0b5a30a4328ab5473878237c447333c093297bded83a4983d10f4deea240d39"
SRC_URI[futures-sink-0.3.5.sha256sum] = "3f2032893cb734c7a05d85ce0cc8b8c4075278e93b24b66f9de99d6eb0fa8acc"
SRC_URI[futures-task-0.3.5.sha256sum] = "bdb66b5f09e22019b1ab0830f7785bcea8e7a42148683f99214f73f8ec21a626"
SRC_URI[futures-util-0.3.5.sha256sum] = "8764574ff08b701a084482c3c7031349104b07ac897393010494beaa18ce32c6"
SRC_URI[gdk-0.13.2.sha256sum] = "db00839b2a68a7a10af3fa28dfb3febaba3a20c3a9ac2425a33b7df1f84a6b7d"
SRC_URI[gdk-pixbuf-0.9.0.sha256sum] = "8f6dae3cb99dd49b758b88f0132f8d401108e63ae8edd45f432d42cdff99998a"
SRC_URI[gdk-pixbuf-sys-0.10.0.sha256sum] = "3bfe468a7f43e97b8d193a762b6c5cf67a7d36cacbc0b9291dbcae24bfea1e8f"
SRC_URI[gdk-sys-0.10.0.sha256sum] = "0a9653cfc500fd268015b1ac055ddbc3df7a5c9ea3f4ccef147b3957bd140d69"
SRC_URI[gio-0.9.1.sha256sum] = "1fb60242bfff700772dae5d9e3a1f7aa2e4ebccf18b89662a16acb2822568561"
SRC_URI[gio-sys-0.10.1.sha256sum] = "5e24fb752f8f5d2cf6bbc2c606fd2bc989c81c5e2fe321ab974d54f8b6344eac"
SRC_URI[glib-0.10.3.sha256sum] = "0c685013b7515e668f1b57a165b009d4d28cb139a8a989bbd699c10dad29d0c5"
SRC_URI[glib-macros-0.10.1.sha256sum] = "41486a26d1366a8032b160b59065a59fb528530a46a49f627e7048fb8c064039"
SRC_URI[glib-sys-0.10.1.sha256sum] = "c7e9b997a66e9a23d073f2b1abb4dbfc3925e0b8952f67efd8d9b6e168e4cdc1"
SRC_URI[gobject-sys-0.10.0.sha256sum] = "952133b60c318a62bf82ee75b93acc7e84028a093e06b9e27981c2b6fe68218c"
SRC_URI[gtk-0.9.2.sha256sum] = "2f022f2054072b3af07666341984562c8e626a79daa8be27b955d12d06a5ad6a"
SRC_URI[gtk-sys-0.10.0.sha256sum] = "89acda6f084863307d948ba64a4b1ef674e8527dddab147ee4cdcc194c880457"
SRC_URI[heck-0.3.1.sha256sum] = "20564e78d53d2bb135c343b3f47714a56af2061f1c928fdb541dc7b9fdd94205"
SRC_URI[hermit-abi-0.1.15.sha256sum] = "3deed196b6e7f9e44a2ae8d94225d80302d81208b1bb673fd21fe634645c85a9"
SRC_URI[humantime-1.3.0.sha256sum] = "df004cfca50ef23c36850aaaa59ad52cc70d0e90243c3c7737a4dd32dc7a3c4f"
SRC_URI[itertools-0.9.0.sha256sum] = "284f18f85651fe11e8a991b2adb42cb078325c996ed026d994719efcfca1d54b"
SRC_URI[lazy_static-1.4.0.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[libc-0.2.72.sha256sum] = "a9f8082297d534141b30c8d39e9b1773713ab50fdbe4ff30f750d063b3bfd701"
SRC_URI[log-0.4.11.sha256sum] = "4fabed175da42fed1fa0746b0ea71f412aa9d35e76e95e59b192c64b9dc2bf8b"
SRC_URI[memchr-2.3.3.sha256sum] = "3728d817d99e5ac407411fa471ff9800a778d88a24685968b36824eaf4bee400"
SRC_URI[once_cell-1.4.0.sha256sum] = "0b631f7e854af39a1739f401cf34a8a013dfe09eac4fa4dba91e9768bd28168d"
SRC_URI[pango-0.9.1.sha256sum] = "9937068580bebd8ced19975938573803273ccbcbd598c58d4906efd4ac87c438"
SRC_URI[pango-sys-0.10.0.sha256sum] = "24d2650c8b62d116c020abd0cea26a4ed96526afda89b1c4ea567131fdefc890"
SRC_URI[pin-project-0.4.22.sha256sum] = "12e3a6cdbfe94a5e4572812a0201f8c0ed98c1c452c7b8563ce2276988ef9c17"
SRC_URI[pin-project-internal-0.4.22.sha256sum] = "6a0ffd45cf79d88737d7cc85bfd5d2894bee1139b356e616fe85dc389c61aaf7"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[pkg-config-0.3.17.sha256sum] = "05da548ad6865900e60eaba7f589cc0783590a92e940c26953ff81ddbab2d677"
SRC_URI[proc-macro2-1.0.18.sha256sum] = "beae6331a816b1f65d04c45b078fd8e6c93e8071771f41b8163255bbd8d7c8fa"
SRC_URI[proc-macro-crate-0.1.5.sha256sum] = "1d6ea3c4595b96363c13943497db34af4460fb474a95c43f4446ad341b8c9785"
SRC_URI[proc-macro-error-1.0.3.sha256sum] = "fc175e9777c3116627248584e8f8b3e2987405cabe1c0adf7d1dd28f09dc7880"
SRC_URI[proc-macro-error-attr-1.0.3.sha256sum] = "3cc9795ca17eb581285ec44936da7fc2335a3f34f2ddd13118b6f4d515435c50"
SRC_URI[proc-macro-hack-0.5.16.sha256sum] = "7e0456befd48169b9f13ef0f0ad46d492cf9d2dbb918bcf38e01eed4ce3ec5e4"
SRC_URI[proc-macro-nested-0.1.6.sha256sum] = "eba180dafb9038b050a4c280019bbedf9f2467b61e5d892dcad585bb57aadc5a"
SRC_URI[quick-error-1.2.3.sha256sum] = "a1d01941d82fa2ab50be1e79e6714289dd7cde78eba4c074bc5a4374f650dfe0"
SRC_URI[quote-1.0.7.sha256sum] = "aa563d17ecb180e500da1cfd2b028310ac758de548efdd203e18f283af693f37"
SRC_URI[regex-1.3.9.sha256sum] = "9c3780fcf44b193bc4d09f36d2a3c87b251da4a046c87795a0d35f4f927ad8e6"
SRC_URI[regex-syntax-0.6.18.sha256sum] = "26412eb97c6b088a6997e05f69403a802a92d520de2f8e63c2b65f9e0f47c4e8"
SRC_URI[serde-1.0.114.sha256sum] = "5317f7588f0a5078ee60ef675ef96735a1442132dc645eb1d12c018620ed8cd3"
SRC_URI[slab-0.4.2.sha256sum] = "c111b5bd5695e56cffe5129854aa230b39c93a305372fdbb2668ca2394eea9f8"
SRC_URI[strum-0.18.0.sha256sum] = "57bd81eb48f4c437cadc685403cad539345bf703d78e63707418431cecd4522b"
SRC_URI[strum_macros-0.18.0.sha256sum] = "87c85aa3f8ea653bfd3ddf25f7ee357ee4d204731f6aa9ad04002306f6e2774c"
SRC_URI[syn-1.0.33.sha256sum] = "e8d5d96e8cbb005d6959f119f773bfaebb5684296108fb32600c00cde305b2cd"
SRC_URI[syn-mid-0.5.0.sha256sum] = "7be3539f6c128a931cf19dcee741c1af532c7fd387baa739c03dd2e96479338a"
SRC_URI[system-deps-1.3.2.sha256sum] = "0f3ecc17269a19353b3558b313bba738b25d82993e30d62a18406a24aba4649b"
SRC_URI[termcolor-1.1.0.sha256sum] = "bb6bfa289a4d7c5766392812c0a1f4c1ba45afa1ad47803c11e1f407d846d75f"
SRC_URI[thiserror-1.0.20.sha256sum] = "7dfdd070ccd8ccb78f4ad66bf1982dc37f620ef696c6b5028fe2ed83dd3d0d08"
SRC_URI[thiserror-impl-1.0.20.sha256sum] = "bd80fc12f73063ac132ac92aceea36734f04a1d93c1240c6944e23a3b8841793"
SRC_URI[thread_local-1.0.1.sha256sum] = "d40c6d1b69745a6ec6fb1ca717914848da4b44ae29d9b3080cbee91d72a69b14"
SRC_URI[toml-0.5.6.sha256sum] = "ffc92d160b1eef40665be3a05630d003936a3bc7da7421277846c2613e92c71a"
SRC_URI[unicode-segmentation-1.6.0.sha256sum] = "e83e153d1053cbb5a118eeff7fd5be06ed99153f00dbcd8ae310c5fb2b22edc0"
SRC_URI[unicode-xid-0.2.1.sha256sum] = "f7fe0bb3479651439c9112f72b6c505038574c9fbb575ed1bf3b797fa39dd564"
SRC_URI[version_check-0.9.2.sha256sum] = "b5a972e5669d67ba988ce3dc826706fb0a8b01471c088cb0b6110b805cc36aed"
SRC_URI[version-compare-0.0.10.sha256sum] = "d63556a25bae6ea31b52e640d7c41d1ab27faba4ccb600013837a3d0b3994ca1"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[winapi-util-0.1.5.sha256sum] = "70ec6ce85bb158151cae5e5c87f95a8e97d2c0c4b001223f33a334e3ce5de178"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"

export SODIUM_USE_PKG_CONFIG = "1"

DEPENDS = "gtk-layer-shell gtk+3 glib-2.0"
BBCLASSEXTEND = "native"
