FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_hid_5.2.patch"
SRC_URI += "file://realsense_metadata_5.2.patch"
SRC_URI += "file://realsense_camera_formats_5.2.patch"
SRC_URI += "file://realsense_powerlinefrequency_control_fix_5.2.patch"
