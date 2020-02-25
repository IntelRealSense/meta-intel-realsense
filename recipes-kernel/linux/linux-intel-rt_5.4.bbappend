FILESEXTRAPATHS_prepend := "${THISDIR}/linux-intel:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_hid_5.4.patch"
SRC_URI += "file://realsense_metadata_5.4.patch"
SRC_URI += "file://realsense_camera_formats_5.4.patch"
SRC_URI += "file://realsense_powerlinefrequency_control_fix_5.4.patch"
