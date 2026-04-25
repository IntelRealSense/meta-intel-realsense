AUTHOR = "Intel® RealSense™"
HOMEPAGE = "https://github.com/IntelRealSense/librealsense"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a1692f06943fa281fd047a22d7e10800"

inherit cmake pkgconfig

DEPENDS = "\
    libusb1 \
    nlohmann-json \
    udev \
"

RRECOMMENDS:${PN} += "kernel-module-uvcvideo"

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;protocol=https;branch=master;rev=fec2d156e531f417c927262818f3440cfbcde4e9"

SRC_URI += "\
	file://use-provided-json-library.patch \
"

EXTRA_OECMAKE = " \
    -DBUILD_UNIT_TESTS:BOOL=OFF \
    -DBUILD_WITH_OPENMP:BOOL=OFF \
    -DCHECK_FOR_UPDATES:BOOL=OFF \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG[rsusb] = "-DFORCE_RSUSB_BACKEND:BOOL=ON,-DFORCE_RSUSB_BACKEND:BOOL=OFF"

