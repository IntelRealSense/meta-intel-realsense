DESCRIPTION = "Python Wrapper for Intel Realsense SDK 2.0"

PR = "r0"

inherit setuptools3

require librealsense2.inc

DEPENDS += "\
    python3-pybind11-native \
"

SRC_URI += "\
    file://use-provided-pybind11.patch \
"

EXTRA_OECMAKE += " \
	-DBUILD_SHARED_LIBS:BOOL=OFF \
    -DPYTHON_EXECUTABLE=${PYTHON} \
    -DBUILD_PYTHON_BINDINGS:BOOL=ON \
    -DBUILD_EXAMPLES:BOOL=OFF \
    -DBUILD_TOOLS:BOOL=OFF \
    -DBUILD_GRAPHICAL_EXAMPLES:BOOL=OFF \
    -DCMAKE_BUILD_TYPE=DEBUG \
"

do_install() {
    install -d ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${S}/wrappers/python/pyrealsense2/__init__.py ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${B}/DEBUG/pyrealsense2.*.so* ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${B}/DEBUG/pyrsutils.*.so* ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
}

FILES:${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/pyrealsense2 \
"

