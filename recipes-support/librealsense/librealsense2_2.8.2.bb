SUMMARY = "Intel® RealSense™ SDK 2.0 is a cross-platform library for Intel® RealSense™ depth cameras (D400 series and the SR300)."
LIC_FILES_CHKSUM = "file://LICENSE;md5=a1692f06943fa281fd047a22d7e10800"

inherit python-dir pythonnative

require librealsense.inc

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libpng libglu glfw gtk+3', '', d)}"

SRC_URI = "\
	git://github.com/IntelRealSense/librealsense.git;tag=v${PV} \
	file://Remove-R200-fix-from-udev-rules.patch \
"

PR = "r0"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
	-DBUILD_SHARED_LIBS:BOOL=ON -DBUILD_UNIT_TESTS:BOOL=OFF -DBUILD_EXAMPLES:BOOL=ON \
	-DBUILD_GRAPHICAL_EXAMPLES:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
"

PACKAGECONFIG ??= "python"
PACKAGECONFIG[python] = "-DBUILD_PYTHON_BINDINGS:BOOL=ON, -DBUILD_PYTHON_BINDINGS:BOOL=OFF, ${PYTHON_PN}"

PACKAGES = "\
	${PN} \
	${PN}-dbg \
	${PN}-dev \
	${PN}-staticdev \
	${PN}-examples \
"

PACKAGES += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', '${PN}-graphical-examples', '', d)}"
PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'python', '${PN}-python', '', d)}"

FILES_${PN}-staticdev += "\
	${libdir}/*.a \
"

FILES_${PN}-python = "\
	${libdir}/py*.so.* \
"

FILES_${PN}-examples += "\
	${bindir}/rs-enumerate-devices \
	${bindir}/rs-save-to-disk \
	${bindir}/rs-terminal \
"

FILES_${PN}-graphical-examples += "\
	${bindir}/realsense-viewer \
	${bindir}/rs-align \
	${bindir}/rs-capture \
	${bindir}/rs-color \
	${bindir}/rs-data-collect \
	${bindir}/rs-depth \
	${bindir}/rs-depth-quality \
	${bindir}/rs-distance \
	${bindir}/rs-multicam \
	${bindir}/rs-pointcloud \
	${bindir}/rs-sensor-control \
"
