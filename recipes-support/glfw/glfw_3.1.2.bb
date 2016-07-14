SUMMARY = "GLFW is an Open Source, multi-platform library for creating windows with OpenGL contexts and receiving input and events."

AUTHOR = "Scott Ware"

LICENSE = "Zlib | Libpng"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=f543d41f3829a608a406b713e4e72731"

DEPENDS = "libpng libglu zlib libxi libxcursor libxinerama libxrandr"

inherit pkgconfig cmake

SRC_URI = "https://github.com/glfw/glfw/releases/download/${PV}/${PN}-${PV}.zip"
SRC_URI[md5sum] = "8023327bfe979b3fe735e449e2f54842"
SRC_URI[sha256sum] = "2a38f4a32d2e1fcdffbe8c70052cd27020f9fef6e769afc8ccf8c7f9a1df635d"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON -DLIB_SUFFIX=${@d.getVar('baselib', True).replace('lib', '')}"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"

FILES_${PN} += "${libdir}/cmake/${PN}"

# Avoid errors regarding cmake library files not being shipped
INSANE_SKIP_${PN} = "${ERROR_QA}"
