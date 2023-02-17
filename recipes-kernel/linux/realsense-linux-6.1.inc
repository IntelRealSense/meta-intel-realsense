FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://hid.cfg"
SRC_URI += "file://uvc.cfg"
SRC_URI += "file://6.1-realsense-camera-formats.patch"
SRC_URI += "file://6.1-realsense-metadata.patch"
SRC_URI += "file://6.1-realsense-hid.patch"
