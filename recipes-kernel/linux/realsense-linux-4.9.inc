FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_hid_4.9.patch"
SRC_URI += "file://realsense_metadata_4.9.patch"
SRC_URI += "file://realsense_camera_formats_4.9.patch"
SRC_URI += "file://realsense_powerlinefrequency_control_fix_4.9.patch"
SRC_URI += "file://discard-frame-on-buffer-overflow.patch"
