FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://hid.cfg"
SRC_URI += "file://uvc.cfg"
SRC_URI += "file://6.2-realsense-camera-formats.patch"
SRC_URI += "file://6.2-realsense-metadata.patch"
