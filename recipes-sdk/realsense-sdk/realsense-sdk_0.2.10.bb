DESCRIPTION = "Linux RealSense SDK recipe"
SECTION="examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=4151db0f01967ef808d8b232acf49628"

SRC_URI="https://github.com/IntelRealSense/realsense_sdk/archive/v${PV}.tar.gz"
SRC_URI[md5sum]="e69641318f2759c27c7485dead5f5660"
SRC_URI[sha256sum]="c3389ce17868af52e0a3f39f82297f54410156b26a28bbe582bb62db3a690ff5"

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


