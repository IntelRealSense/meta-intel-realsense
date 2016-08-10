DESCRIPTION = "Linux object recognition MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENCE.pdf;md5=c36402458f1ce36eb23408ee1ec1bdc9"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/object_recognition/librealsense_object_recognition_20160803.tar.bz2"
SRC_URI[md5sum] = "c771ed6c7cccef135d079e0d67f0ecd1"
SRC_URI[sha256sum] = "aed44430262d1d27e2d3860b0ec9fd8b092fa0d13aee51c9b2310b6f836a1b0d"

inherit pkgconfig

S = "${WORKDIR}/librealsense_object_recognition_20160803"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

RDEPENDS_${PN} = " libopencv-imgproc libopencv-highgui libopencv-core protobuf boost-system zlib boost-filesystem boost-thread libopencv-video libopencv-imgcodecs"
PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"


do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D} LINUX_DISTRIBUTION=yocto
}

FILES_${PN}="/usr/lib \
	    /usr/local/object_recognition \
	    /usr/share/librealsense"

FILES_${PN}-dev = "/usr/include \
  	          "


