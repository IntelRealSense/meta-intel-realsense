DESCRIPTION = "GLFW is an Open Source, multi-platform library for creating windows with OpenGL contexts and receiving input and events."
AUTHOR = "Camilla Berglund"
HOMEPAGE = "http://www.glfw.org/"
LICENSE = "Zlib | Libpng"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=98d93d1ddc537f9b9ea6def64e046b5f"

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

inherit pkgconfig cmake features_check

SRC_URI = "https://github.com/glfw/glfw/releases/download/${PV}/${BPN}-${PV}.zip"
SRC_URI[sha256sum] = "08a33a512f29d7dbf78eab39bd7858576adcc95228c9efe8e4bc5f0f3261efc7"

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
