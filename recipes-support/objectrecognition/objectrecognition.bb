DESCRIPTION = "Linux object recognition MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/object_recognition/librealsense_object_recognition_07_14_2016.tar.gz"
SRC_URI[md5sum] = "110236d47d43e450062fd3807a3c3932"
SRC_URI[sha256sum] = "87a2a277ed3628f5a34f030c89f1eeb55783fdebff56f62124e7ccf5f149fbea"

inherit pkgconfig

S = "${WORKDIR}/librealsense_object_recognition_20160714"

PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"


do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

FILES_${PN}="/usr/lib/*.so \ 
	    /usr/local/OR"

FILES_${PN}-dev = "/usr/include \
  	          "


