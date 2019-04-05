SUMMARY = "Python Wrapper for Intel Realsense SDK 2.0"
AUTHOR = "Intel(R) RealSense(TM)"
HOMEPAGE = "https://github.com/IntelRealSense/librealsense"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=a1692f06943fa281fd047a22d7e10800"

inherit cmake

DEPENDS += "\
    librealsense2 \
"

SRC_URI = "\
	git://github.com/IntelRealSense/librealsense.git;tag=v${PV} \
	file://Fix-CMake-for-standalone-compilation.patch \
"

PR = "r0"

S = "${WORKDIR}/git/wrappers/python"

EXTRA_OECMAKE = " \
	-DUSE_EXTERNAL_USB:BOOL=ON \
	-DPYTHON_EXECUTABLE=${PYTHON} \
"

do_install() {
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${B}/*.so ${D}${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
}

FILES_${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/pyrealsense2/*.so \
"
