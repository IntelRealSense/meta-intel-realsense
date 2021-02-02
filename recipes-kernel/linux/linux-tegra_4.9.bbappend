FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://hid.cfg"
SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_powerlinefrequency_control_fix_4.9.patch"
SRC_URI += "file://discard-frame-on-buffer-overflow.patch"
