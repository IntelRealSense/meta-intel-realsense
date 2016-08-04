DESCRIPTION = "Linux person tracking MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=851ad1ce2b52e6da6970219b7a5af42c"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/projection_opt/projection_opt_20160728.tar.bz2"
SRC_URI[md5sum] = "43d3c4dec264f7dd613e5cbe8a70e053"
SRC_URI[sha256sum] = "be152f43a8f587ea3a4a8828fcdfc06c10f27875b3d9d8c8a5f89a6f3d27fff7"

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



