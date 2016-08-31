DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=851ad1ce2b52e6da6970219b7a5af42c"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/projection_opt/projection_opt_20160825.tar.bz2"
SRC_URI[md5sum] = "949825ebdc2f6b4b0e311a512987c0bc"
SRC_URI[sha256sum] = "356eb8e464f557857b9c9d295557a6682f6677359980f1f0f6be7a04c26abcc5"

inherit pkgconfig

S = "${WORKDIR}/projection_opt"

PR = "r0"
PACKAGES = "${PN} ${PN}-dbg"


do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

FILES_${PN}="/usr/lib/librs_projection_opt.so"
