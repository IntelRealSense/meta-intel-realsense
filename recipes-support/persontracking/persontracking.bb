DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/person_tracking/librealsense_persontracking_0.1.3_17.07.16.tar.gz"
SRC_URI[md5sum] = "3840f752af53f2ab2277a2d61b3f9f1e"
SRC_URI[sha256sum] = "b2eb28069f21d08ddd3d82465595606cbc2ad51ce6ca8d0c573379fe96be9158"


RDEPENDS_${PN} = " libpng12 opencv"
PR = "r0"

inherit pkgconfig

S = "${WORKDIR}/ostro"

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
	    /usr/local/persontracking"

FILES_${PN}-dev = "/usr/include \
  	          "


