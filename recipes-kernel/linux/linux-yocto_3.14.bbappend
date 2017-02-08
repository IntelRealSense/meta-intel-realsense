FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://realsense_camera_uvc_fixes_${PN}_3.14.patch"
SRC_URI += "file://realsense_camera_formats_${PN}_3.14.patch"
