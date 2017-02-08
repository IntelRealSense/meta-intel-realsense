FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_camera_uvc_fixes_linux-yocto_3.14.patch"
SRC_URI += "file://realsense_camera_formats_linux-yocto_3.14.patch"
