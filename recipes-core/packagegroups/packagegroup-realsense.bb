DESCRIPTION = "realsense-sdk package groups"

inherit packagegroup

RDEPENDS_${PN} = " \
    realsense-sdk \
    realsense-persontracking \
    realsense-projectionopt \
    realsense-objectrecognition \
    realsense-slam \
"
