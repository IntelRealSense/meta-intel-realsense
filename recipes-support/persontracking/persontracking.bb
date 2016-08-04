DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/person_tracking/librealsense_persontracking_20160801.tar.bz2"
SRC_URI[md5sum] = "c2f689632722bcfe740ab1eb0d287dbe"
SRC_URI[sha256sum] = "43aae99e1bf0a98f15c9d55b03f2b2d72e513c9a01bef2f22bc489be2de2d573"


RDEPENDS_${PN} = " realsensesdk libpng12 opencv"
PR = "r0"

inherit pkgconfig

S = "${WORKDIR}/git"

PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

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


