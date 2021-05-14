FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://tegra/realsense_powerlinefrequency_control_fix.patch"
SRC_URI += "file://tegra/discard-frame-on-buffer-overflow.patch"
SRC_URI += "file://tegra/Add-Z16H-format.patch"
SRC_URI += "file://tegra/Add-support-for-RealSense-metadata.patch"
SRC_URI += "file://tegra/tegra.cfg"
