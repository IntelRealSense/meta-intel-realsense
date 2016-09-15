DESCRIPTION = "Linux object recognition MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=83f213feb5545ba55f98e2c4c9da3e03"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/object_recognition/librealsense_objectrecognition20160915.tar.bz2"
SRC_URI[md5sum] = "7960b72b98a2e788a7a5b3eaa51a815e"
SRC_URI[sha256sum] = "a34ba5b9ebf6e2d88d20b4b3d74538fb15e7b70843be6a664f7eaceee58aab30"

inherit pkgconfig

S = "${WORKDIR}/librealsense_objectrecognition"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

RDEPENDS_${PN} = " libopencv-imgproc libopencv-highgui libopencv-core protobuf boost-system zlib boost-filesystem boost-thread libopencv-video libopencv-imgcodecs"
PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"



do_compile() {
}

do_install() {
	install -d "${D}${libdir}"
	install -m 0644 ${S}/lib/ostro/* ${D}${libdir}

    mkdir -p "${D}/usr/share/librealsense/object_recognition"
    install -m 0644 ${S}/classifiers/* ${D}/usr/share/librealsense/object_recognition

    mkdir -p "${D}${includedir}/librealsense/object_recognition"
    install -m 0644 ${S}/include/* ${D}/usr/include/librealsense/object_recognition

    ln -sf libcaffe.so.1.0.0-rc3 ${D}${libdir}/libcaffe.so
}

FILES_${PN} += "/usr/lib/libgrabber.so \
    /usr/lib/libobject_recognition.so \
    /usr/lib/libcore.so \
    /usr/lib/libstereoMatching.so \
    /usr/lib/libomekcv.so \
    /usr/lib/libdepthProcessor.so \
    /usr/lib/libLinuxSDK.so \
    /usr/lib/libRGBDUtils.so \
    /usr/lib/libgdebug.so \
    /usr/lib/libinternalInterface.so \
    /usr/lib/liblocalizer.so \
    /usr/share \
    /usr/share/librealsense \
    /usr/share/librealsense/object_recognition \
    /usr/share/librealsense/object_recognition/objects_recognition.classifier \
    /usr/share/librealsense/object_recognition/objects_localization.classifier"
