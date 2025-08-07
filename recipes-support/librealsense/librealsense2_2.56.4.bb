DESCRIPTION = "Intel® RealSense™ SDK 2.0 is a cross-platform library for Intel® RealSense™ depth cameras."
SECTION = "libs"

require librealsense2.inc

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libpng libglu glfw gtk+3', '', d)}"

RDEPENDS:${PN} = "\
    bash \
"
RDEPENDS:${PN}-examples += "\
    ${PN} \
"
RDEPENDS:${PN}-examples += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libgl-mesa', '', d)}"

SRC_URI += "\
	file://remove-libusb-from-targets-list.patch \
	file://remove-R200-fix-from-udev-rules.patch \
"

PR = "r0"

EXTRA_OECMAKE += " \
    -DBUILD_SHARED_LIBS:BOOL=ON \
    -DBUILD_EXAMPLES:BOOL=ON \
    -DBUILD_GRAPHICAL_EXAMPLES:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
    -DBUILD_GLSL_EXTENSIONS:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
"

PACKAGES += "\
    ${PN}-examples \
    ${PN}-tools \
    ${PN}-debug-tools \
"

do_install:append() {
    install -d "${D}${sysconfdir}/udev/rules.d"
    install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d/99-${BPN}-libusb.rules
    
    # Remove preset file
    rm -rf ${D}/tmp
}

FILES:${PN} = "\
    ${libdir}/${PN}*.so.* \
    ${sysconfdir}/udev/rules.d/* \
"

FILES:${PN}-examples = "\
    ${bindir}/rs-color \
    ${bindir}/rs-depth \
    ${bindir}/rs-distance \
    ${bindir}/rs-hello-realsense \
    ${bindir}/rs-pose \
    ${bindir}/rs-pose-and-image \
    ${bindir}/rs-pose-predict \
    ${bindir}/rs-save-to-disk \
    ${bindir}/rs-align \
    ${bindir}/rs-align-advanced \
    ${bindir}/rs-align-gl \
    ${bindir}/rs-ar-advanced \
    ${bindir}/rs-ar-basic \
    ${bindir}/rs-callback \
    ${bindir}/rs-capture \
    ${bindir}/rs-gl \
    ${bindir}/rs-hdr \
    ${bindir}/rs-measure \
    ${bindir}/rs-motion \
    ${bindir}/rs-multicam \
    ${bindir}/rs-pointcloud \
    ${bindir}/rs-post-processing \
    ${bindir}/rs-record-playback \
    ${bindir}/rs-sensor-control \
    ${bindir}/rs-software-device \
    ${bindir}/rs-tracking-and-depth \
    ${bindir}/rs-trajectory \
"

FILES:${PN}-tools = "\
    ${bindir}/realsense-viewer \
    ${bindir}/rs-convert \
    ${bindir}/rs-depth-quality \
    ${bindir}/rs-embed \
    ${bindir}/rs-fw-update \
"

FILES:${PN}-debug-tools = "\
    ${bindir}/rs-benchmark \
    ${bindir}/rs-data-collect \
    ${bindir}/rs-enumerate-devices \
    ${bindir}/rs-fw-logger \
    ${bindir}/rs-record \
    ${bindir}/rs-rosbag-inspector \
    ${bindir}/rs-terminal \
"
PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"
