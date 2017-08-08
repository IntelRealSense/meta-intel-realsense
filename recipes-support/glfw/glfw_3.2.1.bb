DESCRIPTION = "GLFW is an Open Source, multi-platform library for creating windows with OpenGL contexts and receiving input and events."
AUTHOR = "Camilla Berglund"
HOMEPAGE = "http://www.glfw.org/"
LICENSE = "Zlib | Libpng"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=352912f8ce21ff7d8b592a4edbe48f50"

DEPENDS = "libpng libglu zlib libxi libxcursor libxinerama libxrandr"
REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig cmake distro_features_check

SRC_URI = "https://github.com/glfw/glfw/releases/download/${PV}/${PN}-${PV}.zip"
SRC_URI[md5sum] = "824c99eea073bdd6d2fec76b538f79af"
SRC_URI[sha256sum] = "b7d55e13e07095119e7d5f6792586dd0849c9fcdd867d49a4a5ac31f982f7326"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON -DLIB_SUFFIX=${@d.getVar('baselib', True).replace('lib', '')}"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"

FILES_${PN} = "${libdir}"
FILES_${PN}-dev += "${includedir}/GLFW"

# Avoid errors regarding cmake library files not being shipped
INSANE_SKIP_${PN} = "${ERROR_QA}"
