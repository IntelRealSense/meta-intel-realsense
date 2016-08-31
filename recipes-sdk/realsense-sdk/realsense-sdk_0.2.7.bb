DESCRIPTION = "Linux RealSense SDK recipe"
SECTION="examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=4151db0f01967ef808d8b232acf49628"

SRC_URI="https://github.com/IntelRealSense/realsense_sdk/archive/v${PV}.tar.gz"
SRC_URI[md5sum]="23c591b918c9a517f311e36b9bff568e"
SRC_URI[sha256sum]="7090e2e9e72bcd91f5a39d39f1374cb6884a8e17c7d5d5f69f8be5b1314ee246"

DEPENDS="librealsense log4cxx gtest iotivity opencv"
RDEPENDS_${PN}= "librealsense opencv gtest"
RDEPENDS_${PN}-dev= " ${PN}-staticdev"

PR = "r0"

inherit pkgconfig cmake

S = "${WORKDIR}/realsense_sdk-${PV}/sdk"

PACKAGES = "${PN} ${PN}-dev ${PN}-staticdev ${PN}-dbg"

FILES_${PN}+=" \
                /usr/lib/librs_log_utils.so \
                /usr/lib/librs_max_depth_value_module.so \
                /usr/lib/librs_projection.so \
             "


