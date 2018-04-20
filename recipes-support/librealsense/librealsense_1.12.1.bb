SUMMARY = "A cross-platform library for capturing data from the Intel® RealSense™ F200, SR300, R200, LR200 and the ZR300 cameras"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
	git://github.com/IntelRealSense/librealsense.git;branch=legacy \
	file://0001-Generate-cmake-package-config-files.patch \
	file://0002-Remove-R200-fix-from-udev-rules.patch \
	file://0003-Fix-build-for-GCC-7.X.patch \
"
SRCREV = "7332ecadc057552c178addd577d24a2756f8789a"

PR = "r2"

S = "${WORKDIR}/git"

require librealsense-common.inc
require librealsense.inc
