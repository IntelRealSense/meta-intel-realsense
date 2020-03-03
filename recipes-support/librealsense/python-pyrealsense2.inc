SUMMARY = "Python Wrapper for Intel Realsense SDK 2.0"

PR = "r0"

require librealsense2.inc

DEPENDS += "\
    librealsense2 \
"

SRC_URI += "\
    file://Skip-building-main-library.patch \
"

EXTRA_OECMAKE += " \
    -DPYTHON_EXECUTABLE=${PYTHON} \
    -DBUILD_PYTHON_BINDINGS:BOOL=ON \
    -DBUILD_EXAMPLES:BOOL=OFF \
    -DBUILD_GRAPHICAL_EXAMPLES:BOOL=OFF \
    -DBUILD_WITH_TM2:BOOL=OFF \
"

do_install() {
    install -d ${D}/${PYTHON_SITEPACKAGES_DIR}
    install -m 0644 ${B}/wrappers/python/*.so ${D}/${PYTHON_SITEPACKAGES_DIR}
}

FILES_${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/*.so \
"
