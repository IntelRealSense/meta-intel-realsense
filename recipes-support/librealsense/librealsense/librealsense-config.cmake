get_filename_component(_librealsense_rootdir ${CMAKE_CURRENT_LIST_DIR}/../../../ ABSOLUTE)

set(librealsense_INCLUDE_DIRS   ${_librealsense_rootdir}/include/librealsense)
set(librealsense_LIBRARY_DIR    ${_librealsense_rootdir}/lib)
set(librealsense_LIBRARIES      -L${librealsense_LIBRARY_DIR} -lrealsense)

set(librealsense_FOUND_CATKIN_PROJECT TRUE)
