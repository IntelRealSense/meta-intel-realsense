Yocto Layer for librealsense
============================
This layer adds the packages necessary for adding support for Intel® RealSense™ cameras via [librealsense](https://github.com/IntelRealSense/librealsense) to your Yocto distribution.


## Dependencies
This layer depends on packages provided by the following layers:
* `meta-openembedded` [http://cgit.openembedded.org/meta-openembedded/]

Usage
=====
1. Checkout the branch which corresponds with your version of Yocto (e.g. `fido`)
2. Add the `meta-intel-realsense` layer to `conf/bblayers.conf` in your `build` directory
```bitbake
	BBLAYERS += "path/to/meta-intel-realsense"
```
3. Add dependency layers to `conf/bblayers.conf` in your `build` directory
```bitbake
	BBLAYERS += "path/to/meta-openembedded/meta-oe"
```
4. Create a new `conf/auto.conf` file in your `build` directory with the following contents
```bitbake
    require include/intel-librealsense.inc
```
5. If you are building an image with a graphical desktop you can add the following to `conf/auto.conf`
```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "librealsense-graphical-examples"
```

License
=======
This project is Copyright (C) 2015 Intel Corporation. Please see the LICENSE file for more information.
