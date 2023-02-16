FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://hid.cfg"
SRC_URI += "file://uvc.cfg"
SRC_URI += "file://5.19-realsense-camera-formats.patch"
SRC_URI += "file://5.19-realsense-metadata.patch"
SRC_URI += "file://5.19-realsense-hid.patch"
SRC_URI += "file://5.19-power-line-frequency-enumeration-map-update.patch"
