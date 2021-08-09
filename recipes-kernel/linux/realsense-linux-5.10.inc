FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://hid.cfg"
SRC_URI += "file://uvc.cfg"
SRC_URI += "file://Add-missing-HID-timestamp-patch-for-Gyro-sensor_5.10.patch"
SRC_URI += "file://Add-support-for-RealSense-camera-formats-metadata_5.10.patch"
SRC_URI += "file://Bug-fix-for-incomplete-PowerLineFrequency-enumeration_5.10.patch"
