SUMMARY = "Reference implementation of JPEG XL (encoder and decoder)"
HOMEPAGE = "https://github.com/libjxl/libjxl/" 

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a905a337cc228a1f68f0b5416f52a7f" 

inherit cmake pkgconfig pixbufcache mime

DEPENDS = "gdk-pixbuf gdk-pixbuf-native"

SRC_URI = " \
    gitsm://github.com/libjxl/libjxl.git;protocol=https;nobranch=1 \
"

PV = "0.10.2"
SRCREV = "e1489592a770b989303b0edc5cc1dc447bbe0515"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
	-DJPEGXL_BUNDLE_LIBPNG=OFF \
	-DCMAKE_BUILD_TYPE=Release \
	-DJPEGXL_ENABLE_PLUGINS=ON\
	-DBUILD_TESTING=OFF \
	-DJPEGXL_WARNINGS_AS_ERRORS=OFF \
	-DJPEGXL_ENABLE_SIZELESS_VECTORS=ON \
	-DJPEGXL_ENABLE_SIZELESS_VECTORS=ON \
	-DJPEGXL_ENABLE_SJPEG=OFF \
	-DJPEGXL_ENABLE_BENCHMARK=OFF \
	-DJPEGXL_ENABLE_EXAMPLES=OFF \
	-DJPEGXL_ENABLE_MANPAGES=OFF \
	-DJPEGXL_ENABLE_SKCMS=OFF \
	-DJPEGXL_ENABLE_JNI=OFF \
	-DJPEGXL_ENABLE_TCMALLOC=OFF \
	-DJPEGXL_ENABLE_TOOLS=OFF \
	-DJPEGXL_ENABLE_VIEWERS=OFF \
"

CXXFLAGS:append:arm = " -mfp16-format=ieee"

FILES:${PN} += "\
        ${libdir}/gdk-pixbuf-2.0/*/*/*.so \
        ${datadir}/thumbnailers/jxl.thumbnailer \
        ${datadir}/mime/packages/image-jxl.xml \
"
