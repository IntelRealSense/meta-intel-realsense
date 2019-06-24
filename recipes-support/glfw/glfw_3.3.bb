DESCRIPTION = "GLFW is an Open Source, multi-platform library for creating windows with OpenGL contexts and receiving input and events."
AUTHOR = "Camilla Berglund"
HOMEPAGE = "http://www.glfw.org/"
LICENSE = "Zlib | Libpng"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=90c6dd54408744b0f8a55f2a6c7ad870"

DEPENDS = "\
    libpng \
    libglu \
    zlib \
    libxi \
    libxcursor \
    libxinerama \
    libxrandr \
"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig cmake distro_features_check

SRC_URI = "https://github.com/glfw/glfw/releases/download/${PV}/${BPN}-${PV}.zip"
SRC_URI[md5sum] = "e4f3c4848710093f29b1781f2d1b7acc"
SRC_URI[sha256sum] = "36fda4cb173e3eb2928c976b0e9b5014e2e5d12b9b787efa0aa29ffc41c37c4a"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECMAKE += "\
    -DBUILD_SHARED_LIBS=ON \
    -DGLFW_BUILD_EXAMPLES=OFF \
    -DGLFW_BUILD_TESTS=OFF \
    -DGLFW_USE_WAYLAND=OFF \
    -DLIB_SUFFIX=${@d.getVar('baselib', True).replace('lib', '')} \
"

FILES_${PN}-dev += "\
    ${libdir}/cmake \
"
