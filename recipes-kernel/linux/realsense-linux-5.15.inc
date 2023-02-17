FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://hid.cfg"
SRC_URI += "file://5.15-uvc.cfg"
SRC_URI += "file://5.15-realsense-camera-formats.patch"
SRC_URI += "file://5.15-realsense-metadata.patch"
SRC_URI += "file://5.15-realsense-hid.patch"
SRC_URI += "file://5.15-power-line-frequency-enumeration-map-update.patch"
