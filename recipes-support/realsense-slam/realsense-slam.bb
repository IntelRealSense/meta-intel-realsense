DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f7c23b289a820d06b7c0ba8064f70fd8"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/slam/librealsense_slam_20160908.tar.bz2"
SRC_URI[md5sum] = "044b593bd6b9dcee3eefe76808a8a596"
SRC_URI[sha256sum] = "5319d2cd3346dded09429d8a75c562f2594aa3f7bb78e6944b0b547d25e37138"

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


