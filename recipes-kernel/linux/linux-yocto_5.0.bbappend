FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_hid_5.0.patch"
SRC_URI += "file://realsense_metadata_5.0.patch"
SRC_URI += "file://realsense_camera_formats_5.0.patch"
SRC_URI += "file://realsense_powerlinefrequency_control_fix_5.0.patch"
