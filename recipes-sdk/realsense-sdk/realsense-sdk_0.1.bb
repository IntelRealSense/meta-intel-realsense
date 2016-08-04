DESCRIPTION = "Linux RealSense SDK recipe"
SECTION="examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=4151db0f01967ef808d8b232acf49628"

SRC_URI="https://github.com/IntelRealSense/realsense_sdk/archive/v${PV}.tar.gz"
SRC_URI[md5sum]="4e959500d7c56d1cfa19aeb27a25e2f4"
SRC_URI[sha256sum]="fbb03254136103b83fdf5a1c97fd685d0c9894cb1286f9c4c2d8a7faa2562b86"

DEPENDS=" libjpeg-turbo freetype libxml2 fontconfig python glib-2.0 cairo tiff atk v4l-utils gdk-pixbuf gtk+ pango librealsense log4cxx gtest iotivity opencv"
RDEPENDS_${PN}= "librealsense opencv gtest"
RDEPENDS_${PN}-dev= " ${PN}-staticdev"

PR = "r0"

inherit pkgconfig cmake

S = "${WORKDIR}/realsense_sdk-${PV}/sdk"


PACKAGES = "${PN} ${PN}-dev ${PN}-staticdev ${PN}-dbg"

FILES_${PN}="/usr/bin \
             /usr/lib/*.so"

FILES_${PN}-dev ="/usr/include/ "
FILES_${PN}-staticdev ="/usr/lib/*.a"



