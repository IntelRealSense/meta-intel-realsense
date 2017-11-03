SUMMARY = "A cross-platform library for capturing data from the Intel® RealSense™ F200, SR300, R200, LR200 and the ZR300 cameras"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

require librealsense.inc

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libpng libglu glfw', '', d)}"

SRC_URI = "\
	git://github.com/IntelRealSense/librealsense.git;branch=legacy \
	file://0001-Generate-cmake-package-config-files.patch \
	file://0002-Remove-R200-fix-from-udev-rules.patch \
"
SRCREV = "7332ecadc057552c178addd577d24a2756f8789a"

PR = "r2"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
	-DBUILD_SHARED_LIBS:BOOL=ON -DBUILD_UNIT_TESTS:BOOL=OFF \
	-DBUILD_EXAMPLES:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
"
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PACKAGES += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', '${PN}-examples ${PN}-graphical-examples', '', d)}"

FILES_${PN}-examples += "\
	${bindir}/cpp-callback \
	${bindir}/cpp-enumerate-devices \
	${bindir}/cpp-headless \
	${bindir}/cpp-motion-module \
	${bindir}/cpp-tutorial-1-depth \
	${bindir}/c-tutorial-1-depth \
"

FILES_${PN}-graphical-examples += "\
	${bindir}/cpp-alignimages \
	${bindir}/cpp-callback-2 \
	${bindir}/cpp-capture \
	${bindir}/cpp-config-ui \
	${bindir}/cpp-multicam \
	${bindir}/cpp-pointcloud \
	${bindir}/cpp-restart \
	${bindir}/cpp-stride \
	${bindir}/cpp-tutorial-2-streams \
	${bindir}/cpp-tutorial-3-pointcloud \
	${bindir}/c-tutorial-2-streams \
	${bindir}/c-tutorial-3-pointcloud \
"
