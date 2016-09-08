DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=851ad1ce2b52e6da6970219b7a5af42c"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/projection_opt/projection_opt_20160906.tar.bz2"
SRC_URI[md5sum] = "d5f8ac3656db5d322c8fb6059b15d52d"
SRC_URI[sha256sum] = "39c76c61835c1f4c52b7c5ee53d376e2c6406e456e834cf86fb814b504437a68"

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
