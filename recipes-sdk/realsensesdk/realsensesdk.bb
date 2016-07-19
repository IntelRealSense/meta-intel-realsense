DESCRIPTION = "Linux RealSense SDK recipe"
SECTION="examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4151db0f01967ef808d8b232acf49628"

SRC_URI="git://github.com/IntelRealSense/realsense_sdk.git;branch=development"
SRCREV="d6912446ec7556b41126de1270d20c3fb3d0ee09"

DEPENDS=" libjpeg-turbo freetype libxml2 fontconfig python glib-2.0 cairo tiff atk v4l-utils gdk-pixbuf gtk+ pango librealsense log4cxx gtest iotivity opencv"
RDEPENDS_${PN}= "librealsense opencv gtest"
RDEPENDS_${PN}-dev= " ${PN}-staticdev"

PR = "r0"

inherit pkgconfig cmake

S = "${WORKDIR}/git"


PACKAGES = "${PN} ${PN}-dev ${PN}-staticdev ${PN}-dbg"

FILES_${PN}="/usr/bin \
             /usr/lib/*.so"

FILES_${PN}-dev ="/usr/include/ "
FILES_${PN}-staticdev ="/usr/lib/*.a"
