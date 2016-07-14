SUMMARY = "librealsense for Ostro GT"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
    librealsense \
    librealsense-examples \
    librealsense-graphical-examples \
"
