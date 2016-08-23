DESCRIPTION = "Linux object recognition MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=83f213feb5545ba55f98e2c4c9da3e03"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/object_recognition/librealsense_object_recognition_20160815.tar.bz2"
SRC_URI[md5sum] = "6293c69bdbecb3103ac2cd2014a51efb"
SRC_URI[sha256sum] = "1f01b7a3984a8d06f96c387dcd338226b253769ecc922e79585e8076fae371b7"

inherit pkgconfig

S = "${WORKDIR}/librealsense_object_recognition_20160815"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

RDEPENDS_${PN} = " libopencv-imgproc libopencv-highgui libopencv-core protobuf boost-system zlib boost-filesystem boost-thread libopencv-video libopencv-imgcodecs"
PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"


do_compile() {
}

do_install() {
	install -d "${D}${libdir}"
    	install -m 0644 ${S}/lib/* ${D}${libdir}

        mkdir -p "${D}/usr/share/librealsense/object_recognition"
        install -m 0644 ${S}/classifiers/* ${D}/usr/share/librealsense/object_recognition

        mkdir -p "${D}${includedir}/librealsense/object_recognition"
        install -m 0644 ${S}/include/* ${D}/usr/share/librealsense/object_recognition

        ln -sf libcaffe.so.1.0.0-rc3 ${D}${libdir}/libcaffe.so
}

FILES_${PN} += "/usr/lib/libgrabber.so \
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