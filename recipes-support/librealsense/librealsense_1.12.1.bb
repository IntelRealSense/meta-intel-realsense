require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=master \
           file://0001-Generate-cmake-package-config-files.patch \
           "
SRCREV = "7332ecadc057552c178addd577d24a2756f8789a"

PR = "r0"

S = "${WORKDIR}/git"
