DESCRIPTION = "realsensesdk package groups"

inherit packagegroup

RDEPENDS_${PN} = " \
    packagegroup-librealsense \
    persontracking \
"
