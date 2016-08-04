DESCRIPTION = "Linux RealSense SDK recipe"
SECTION="examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4151db0f01967ef808d8b232acf49628"

SRC_URI="git://github.com/IntelRealSense/realsense_sdk.git;branch=master"
SRCREV="e5388b61cb9b6627ec2d9d04d2285c2694c6f062"

DEPENDS="librealsense log4cxx gtest iotivity opencv"
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
