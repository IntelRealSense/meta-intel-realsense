DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/person_tracking/librealsense_persontracking_20160907_1.tar.bz2"
SRC_URI[md5sum] = "e221103b5b852f6b84a5124c8f1e0bab"
SRC_URI[sha256sum] = "233c928385cdc916f3b59dc717e6b92d7dd6b31dea77fa4c6f9a7faeb417dea9"


RDEPENDS_${PN} = " realsense-sdk libpng12 opencv"
PR = "r0"

inherit pkgconfig

S = "${WORKDIR}/librealsense_persontracking/"

PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D} LINUX_DISTRIBUTION=yocto
}

FILES_${PN}="/usr/lib/*.so \
	    /usr/local/persontracking \
	    /usr/share/librealsense"

FILES_${PN}-dev = "/usr/include \
  	          "


