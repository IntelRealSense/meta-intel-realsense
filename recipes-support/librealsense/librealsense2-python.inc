inherit python-dir pythonnative

export STAGING_INCDIR
export STAGING_LIBDIR
export BUILD_SYS
export HOST_SYS

PACKAGECONFIG[python] = "-DBUILD_PYTHON_BINDINGS:BOOL=ON, -DBUILD_PYTHON_BINDINGS:BOOL=OFF, ${PYTHON_PN}"

PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'python', '${PN}-python ${PN}-python-dev', '', d)}"

FILES_${PN}-python = "\
	${libdir}/py*.so.* \
"

FILES_${PN}-python-dev = "\
	${libdir}/py*.so \
"
