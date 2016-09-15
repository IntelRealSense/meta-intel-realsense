DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c3a7207e0adf283763469a41486cd4f5"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/slam/librealsense_slam_20160914.tar.bz2"
SRC_URI[md5sum] = "17ce4c5f89861b56d04caa5a3db86860"
SRC_URI[sha256sum] = "2a15d71044ea7e5a05bd4f4aa8924af5190fc93dc20d2d4030b4d3410672376f"

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


