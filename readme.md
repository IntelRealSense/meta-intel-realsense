Yocto Layer for librealsense
============================
This layer adds the packages necessary for adding support for Intel® RealSense™ cameras via [librealsense](https://github.com/IntelRealSense/librealsense) to your Yocto distribution.

## Dependencies
This layer depends on packages provided by the following layers:
* `meta-openembedded` [http://cgit.openembedded.org/meta-openembedded/]

Usage
=====
### Yocto Poky
1. Checkout the branch which corresponds with your version of Yocto
2. Add the `meta-intel-realsense` layer to `conf/bblayers.conf` in your `build` directory
```bitbake
    BBLAYERS += "path/to/meta-intel-realsense"
```
3. Add dependency layers to `conf/bblayers.conf` in your `build` directory
```bitbake
    BBLAYERS += "path/to/meta-openembedded/meta-oe"
```
4. Include librealsense in your image by adding the following to `conf/auto.conf`
```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "librealsense2 librealsense2-tools"

    # Optional
    CORE_IMAGE_EXTRA_INSTALL += "librealsense2-debug-tools"
```
### Samples
To include sample apps in your image add the following to `conf/auto.conf`
```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "librealsense2-examples"
```
If you are building an image with a graphical desktop you can also add the following
```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "librealsense2-graphical-examples"
```

### Python
To include Python support in your image include the following in your `conf/auto.conf`

```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "python3-pyrealsense2"
```

License
=======
This project is Copyright (C) 2015 Intel Corporation. Please see the LICENSE file for more information.
