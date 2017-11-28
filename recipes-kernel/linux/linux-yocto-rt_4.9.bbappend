FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_hid_linux-yocto_4.9.patch"
SRC_URI += "file://realsense_metadata_linux-yocto_4.9.patch"
SRC_URI += "file://realsense_powerlinefrequency_control_fix_linux-yocto_4.9.patch"
SRC_URI += "file://realsense_camera_formats_linux-yocto_4.9.patch"
