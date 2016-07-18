DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/slam/librealsense_slam_binaryversion_07_01_2016.tar.gz"
SRC_URI[md5sum] = "110236d47d43e450062fd3807a3c3932"
SRC_URI[sha256sum] = "d3d47e221ec528cd8fc5804055329808b2e60575c12a4cefae814a279e075441"


RDEPENDS_${PN} = " libpng12 opencv"
PR = "r0"

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


