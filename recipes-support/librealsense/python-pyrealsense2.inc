DESCRIPTION = "Python Wrapper for Intel Realsense SDK 2.0"

PR = "r0"

require librealsense2.inc

DEPENDS += "\
    librealsense2 \
"

SRC_URI += "git://github.com/pybind/pybind11.git;protocol=https;rev=8de7772cc72daca8e947b79b83fea46214931604;branch=master;destsuffix=pybind11;name=pybind11 \
           file://Skip-building-the-main-library.patch \
           file://Avoid-pulling-pybind11-during-configuration.patch \
"

do_unpack:append() {
    bb.build.exec_func('populate_pybind11', d)
}

populate_pybind11(){
    rm -rf ${GITDIR}/third-party/pybind11
    cp -R ${WORKDIR}/pybind11 ${S}/third-party
}

EXTRA_OECMAKE += " \
    -DPYTHON_EXECUTABLE=${PYTHON} \
    -DBUILD_PYTHON_BINDINGS:BOOL=ON \
    -DBUILD_EXAMPLES:BOOL=OFF \
    -DBUILD_TOOLS:BOOL=OFF \
    -DBUILD_GRAPHICAL_EXAMPLES:BOOL=OFF \
    -DBUILD_WITH_TM2:BOOL=OFF \
"

do_install() {
    install -d ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${S}/wrappers/python/pyrealsense2/__init__.py ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
    install -m 0644 ${B}/wrappers/python/*.so ${D}/${PYTHON_SITEPACKAGES_DIR}/pyrealsense2
}

FILES:${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/pyrealsense2 \
"
