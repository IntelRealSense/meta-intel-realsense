SUMMARY = "A cross-platform library for capturing data from the Intel® RealSense™ F200, SR300, R200, LR200 and the ZR300 cameras"
AUTHOR = "Intel Corporation"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libusb1"
DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libpng libglu glfw', '', d)}"
RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-examples += "${PN}"
RDEPENDS_${PN}-graphical-examples += "${PN} libgl-mesa"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
	-DBUILD_SHARED_LIBS:BOOL=ON -DBUILD_UNIT_TESTS:BOOL=OFF \
	-DBUILD_EXAMPLES:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
"

do_install_append() {
	install -d "${D}${sysconfdir}/udev/rules.d"
	install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d

	install -d "${D}${exec_prefix}/local/bin"
	install -m 0755 ${S}/config/usb-R200-in ${D}${exec_prefix}/local/bin
	install -m 0755 ${S}/config/usb-R200-in_udev ${D}${exec_prefix}/local/bin
}

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PACKAGES += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', '${PN}-examples ${PN}-graphical-examples', '', d)}"

FILES_${PN} = "\
	${libdir}/*.so.* \
	${sysconfdir}/udev/rules.d/* \
	${exec_prefix}/local/bin/* \
"

FILES_${PN}-dev += "\
	${libdir}/*.so \
	${includedir}/${PN} \
	${libdir}/cmake \
"

FILES_${PN}-dbg += "${bindir}/.debug"

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
