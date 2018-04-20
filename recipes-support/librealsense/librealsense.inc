DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'libpng libglu glfw', '', d)}"

EXTRA_OECMAKE = " \
	-DBUILD_SHARED_LIBS:BOOL=ON -DBUILD_UNIT_TESTS:BOOL=OFF \
	-DBUILD_EXAMPLES:BOOL=${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'ON', 'OFF', d)} \
"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PACKAGES += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', '${PN}-examples ${PN}-graphical-examples', '', d)}"

FILES_${PN}-examples += "\
	${bindir}/cpp-callback \
	${bindir}/cpp-enumerate-devices \
	${bindir}/cpp-headless \
	${bindir}/cpp-motion-module \
	${bindir}/cpp-tutorial-1-depth \
	${bindir}/c-tutorial-1-depth \
"

FILES_${PN}-graphical-examples += "\
	${bindir}/cpp-alignimages \
	${bindir}/cpp-callback-2 \
	${bindir}/cpp-capture \
	${bindir}/cpp-config-ui \
	${bindir}/cpp-multicam \
	${bindir}/cpp-pointcloud \
	${bindir}/cpp-restart \
	${bindir}/cpp-stride \
	${bindir}/cpp-tutorial-2-streams \
	${bindir}/cpp-tutorial-3-pointcloud \
	${bindir}/c-tutorial-2-streams \
	${bindir}/c-tutorial-3-pointcloud \
"
