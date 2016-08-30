SUMMARY = "librealsense for Ostro XT"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
    librealsense \
    librealsense-examples \
    librealsense-graphical-examples \
    librealsense-tests \
"
