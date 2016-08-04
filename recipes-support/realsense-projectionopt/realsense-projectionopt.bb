DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=851ad1ce2b52e6da6970219b7a5af42c"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/projection_opt/projection_opt_20160718.tar.bz2"
SRC_URI[md5sum] = "bdb6b31d1660583a79c85473e94e1b47"
SRC_URI[sha256sum] = "649b51d7609626441c3a95c59cba73242ffd733af3d36acc4b12aa2c76694a22"

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



