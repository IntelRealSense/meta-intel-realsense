DESCRIPTION = "Linux RealSense SDK recipe"
SECTION="examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=4151db0f01967ef808d8b232acf49628"

SRC_URI="https://github.com/IntelRealSense/realsense_sdk/archive/v${PV}.tar.gz"
SRC_URI[md5sum]="cad24377ebc0f5fa230b8d5259e84937"
SRC_URI[sha256sum]="1bf2d081fd7d5f2b0abfea30b9db4c06cf6c05f6bedfbd6597f74416feab1a2f"

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


