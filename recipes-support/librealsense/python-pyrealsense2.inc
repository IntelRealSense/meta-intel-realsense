DESCRIPTION = "Python Wrapper for Intel Realsense SDK 2.0"

PR = "r0"

require librealsense2.inc

DEPENDS += "\
    librealsense2 \
    python3-pybind11-native \
"

SRC_URI += "\
    file://skip-building-the-main-library.patch \
    file://use-provided-pybind11.patch \
"

EXTRA_OECMAKE += " \
    -DPYTHON_EXECUTABLE=${PYTHON} \
    -DBUILD_PYTHON_BINDINGS:BOOL=ON \
    -DBUILD_EXAMPLES:BOOL=OFF \
    -DBUILD_TOOLS:BOOL=OFF \
    -DBUILD_GRAPHICAL_EXAMPLES:BOOL=OFF \
    -DBUILD_WITH_TM2:BOOL=OFF \
    -DCMAKE_BUILD_TYPE=DEBUG \
"

do_install() {
    install -d ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${S}/wrappers/python/pyrealsense2/__init__.py ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${B}/wrappers/python/*.so ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
}

FILES:${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/pyrealsense2 \
"
