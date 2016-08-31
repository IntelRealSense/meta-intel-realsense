DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fe550471340e52860f40f0bb24b3a699"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/slam/librealsense_slam_20160830.tar.bz2"
SRC_URI[md5sum] = "d211550fa906774fbe45676fe6867f34"
SRC_URI[sha256sum] = "54f7ccdb4192c7eecefdafc167068a66e08e9e7720931016126ef72685ab5aff"

inherit pkgconfig

RDEPENDS_${PN} = "ocl-icd opencv"

S = "${WORKDIR}/librealsense_slam_20160830"

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


