SUMMARY = "Intel® RealSense™ SDK 2.0 is a cross-platform library for Intel® RealSense™ depth cameras (D400 series and the SR300) and the T265 tracking camera."
AUTHOR = "Intel(R) RealSense(TM)"
HOMEPAGE = "https://github.com/IntelRealSense/librealsense"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a1692f06943fa281fd047a22d7e10800"

SRC_URI = "\
    git://github.com/IntelRealSense/librealsense.git;tag=v${PV} \
    file://Remove-R200-fix-from-udev-rules.patch \
"

PR = "r0"

S = "${WORKDIR}/git"

require librealsense2.inc
