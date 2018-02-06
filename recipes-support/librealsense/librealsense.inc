AUTHOR = "Intel Corporation"
SECTION = "libs"
LICENSE = "Apache-2.0"

DEPENDS = "\
    udev \
    libusb1 \
"

RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-examples += "${PN}"
RDEPENDS_${PN}-graphical-examples += "${PN} libgl-mesa"

inherit cmake pkgconfig

do_install_append() {
	install -d "${D}${sysconfdir}/udev/rules.d"
	install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d/99-${PN}-libusb.rules
}

FILES_${PN} = "\
	${libdir}/${PN}.so.* \
	${sysconfdir}/udev/rules.d/* \
"

FILES_${PN}-dev += "\
	${libdir}/*.so \
	${includedir}/${PN} \
	${libdir}/cmake \
	${libdir}/pkgconfig \
"

FILES_${PN}-dbg += "\
	${bindir}/.debug \
	${libdir}/.debug \
"
