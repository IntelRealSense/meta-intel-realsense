DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fe550471340e52860f40f0bb24b3a699"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/slam/librealsense_slamdr_20160718.tar.bz2"
SRC_URI[md5sum] = "9e9f2e096ed4381863d92f0e780babd7"
SRC_URI[sha256sum] = "fff467ee50fb1ff25544a3fffde62ee95237a3d9d63cbdf7cd7b0922978a0ac9"

inherit pkgconfig

RDEPENDS_${PN} = "ocl-icd"

S = "${WORKDIR}/librealsense_slamdr_20160718"

PR = "r0"
PACKAGES = "${PN} ${PN}-dev"


do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN}="/usr/lib/*"

FILES_${PN}-dev = "/usr/include"


