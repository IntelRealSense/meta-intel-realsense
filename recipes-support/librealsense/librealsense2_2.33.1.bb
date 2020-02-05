SUMMARY = "Intel® RealSense™ SDK 2.0 is a cross-platform library for Intel® RealSense™ depth cameras (D400 series and the SR300) and the T265 tracking camera."
SECTION = "libs"

require librealsense2.inc

DEPENDS = "\
    udev \
    libusb1 \
"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libpng libglu glfw gtk+3', '', d)}"

RDEPENDS_${PN} = "\
    bash \
"
RDEPENDS_${PN}-examples += "\
    ${PN} \
"
RDEPENDS_${PN}-graphical-examples += "\
    ${PN} \
    libgl-mesa \
"

SRC_URI += "\
    file://Remove-R200-fix-from-udev-rules.patch \
"

PR = "r0"

EXTRA_OECMAKE += " \
    -DBUILD_SHARED_LIBS:BOOL=ON \
    -DBUILD_EXAMPLES:BOOL=ON \
    -DBUILD_GRAPHICAL_EXAMPLES:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
"

PACKAGES += "\
    ${PN}-examples \
    ${PN}-tools \
    ${PN}-debug-tools \
"

PACKAGES += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', '${PN}-graphical-examples', '', d)}"

do_install_append() {
    install -d "${D}${sysconfdir}/udev/rules.d"
    install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d/99-${BPN}-libusb.rules
}

FILES_${PN} = "\
    ${libdir}/${PN}*.so.* \
    ${sysconfdir}/udev/rules.d/* \
"

FILES_${PN}-examples = "\
    ${bindir}/rs-color \
    ${bindir}/rs-depth \
    ${bindir}/rs-distance \
    ${bindir}/rs-hello-realsense \
    ${bindir}/rs-pose \
    ${bindir}/rs-pose-and-image \
    ${bindir}/rs-pose-predict \
    ${bindir}/rs-save-to-disk \
"

FILES_${PN}-graphical-examples = "\
    ${bindir}/rs-align \
    ${bindir}/rs-align-advanced \
    ${bindir}/rs-ar-advanced \
    ${bindir}/rs-ar-basic \
    ${bindir}/rs-callback \
    ${bindir}/rs-capture \
    ${bindir}/rs-gl \
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

FILES_${PN}-tools = "\
    ${bindir}/realsense-viewer \
    ${bindir}/rs-convert \
    ${bindir}/rs-depth-quality \
    ${bindir}/rs-fw-update \
"

FILES_${PN}-debug-tools = "\
    ${bindir}/rs-benchmark \
    ${bindir}/rs-data-collect \
    ${bindir}/rs-enumerate-devices \
    ${bindir}/rs-fw-logger \
    ${bindir}/rs-record \
    ${bindir}/rs-rosbag-inspector \
    ${bindir}/rs-terminal \
"
