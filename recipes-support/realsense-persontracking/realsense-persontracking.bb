DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/person_tracking/librealsense_persontracking_20160830.tar.bz2"
SRC_URI[md5sum] = "695e54cd6e268372a9da0021d5bc634c"
SRC_URI[sha256sum] = "f4aa203efeaff6889ab4d744885bd1efa41adfd9ec517d62290b010c7531b67c"


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


