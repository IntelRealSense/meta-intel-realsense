DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fe550471340e52860f40f0bb24b3a699"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/slam/librealsense_slam_20160906.tar.bz2"
SRC_URI[md5sum] = "2380b52f05789c139365f516edbc05a0"
SRC_URI[sha256sum] = "14e8470e554143423399a53a9125ce912030b7ea1e23b7528548d50c7bc65d5d"

inherit pkgconfig

RDEPENDS_${PN} = "ocl-icd opencv"

S = "${WORKDIR}/librealsense_slam"

PR = "r0"
PACKAGES = "${PN} ${PN}-dev"


do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D} LINUX_DISTRIBUTION=yocto
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN}="/usr/lib/*"

FILES_${PN}-dev = "/usr/include"


