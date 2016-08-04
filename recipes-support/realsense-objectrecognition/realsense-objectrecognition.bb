DESCRIPTION = "Linux object recognition MW binary and headers"
SECTION="examples"
LICENSE = "Intel"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f235a25ae606c05d89cf485b7ab9663b"

SRC_URI="https://s3-eu-west-1.amazonaws.com/realsense-linux/x86_64-ostro-linux-gnu/object_recognition/librealsense_object_recognition_20160803.tar.bz2"
SRC_URI[md5sum] = "c771ed6c7cccef135d079e0d67f0ecd1"
SRC_URI[sha256sum] = "aed44430262d1d27e2d3860b0ec9fd8b092fa0d13aee51c9b2310b6f836a1b0d"

inherit pkgconfig

S = "${WORKDIR}/librealsense_object_recognition_20160714"

PR = "r0"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"


do_configure() {
}

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D} LINUX_DISTRIBUTION=yocto
}

FILES_${PN}="/usr/lib/*.so \ 
	    /usr/local/object_recognition \
	    /usr/share/librealsense"

FILES_${PN}-dev = "/usr/include \
  	          "


