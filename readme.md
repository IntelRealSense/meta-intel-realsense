Yocto Layer for librealsense
============================
This layer adds the packages necessary for adding support for Intel® RealSense™ cameras via [librealsense](https://github.com/IntelRealSense/librealsense) to your Yocto distribution.

## Supported Branches
* Yocto Poky 1.8 (fido)
* Yocto Poky 2.0 (Jethro)
* Wind River IDP 3.X
* Ostro™ OS 1.0.0

## Dependencies
This layer depends on packages provided by the following layers:
* `meta-openembedded` [http://cgit.openembedded.org/meta-openembedded/]

Usage
=====
### Yocto Poky
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

### Wind River IDP
1. Checkout the branch which corresponds to your version of Wind River IDP (e.g. `idp_3.x`)
2. Include the following in your project configure command
```bitbake
    --with-layer=/path/to/meta-intel-librealsense
    --with-package=librealsense,librealsense-examples
```

### Ostro OS
1. Checkout the `ostro` branch to your project directory
2. Add the `meta-intel-realsense` layer to `conf/bblayers.conf` in your `build` directory
```bitbake
	OSTRO_LAYERS += "path/to/meta-intel-realsense"
```
3. Create a new `conf/auto.conf` file in your `build` directory with the following contents
```bitbake
    require include/intel-librealsense.inc
```
4. If you are building an image with a graphical desktop you can add the following to `conf/auto.conf`
```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "librealsense-graphical-examples"
```

License
=======
This project is Copyright (C) 2015 Intel Corporation. Please see the LICENSE file for more information.
