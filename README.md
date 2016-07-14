Yocto Layer for RealSense
============================
This layer adds the packages necessary for adding support for Intel® RealSense cameras via [librealsense](https://github.com/IntelRealSense/librealsense) to your Ostro distribution.
This layer also adds the packages necessary for RealSense [Linux SDK](https://github.com/IntelRealSense/realsense_sdk) and Middlewares to your Ostro distribution.


## Dependencies
This layer depends on packages provided by the following layers:
* `meta-openembedded` [http://cgit.openembedded.org/meta-openembedded/]

Usage
### Ostro OS
1. Checkout the `master` branch to your project directory
2. Add the `meta-intel-realsense` layer to `conf/bblayers.conf` in your `build` directory
```bitbake
	OSTRO_LAYERS += "path/to/meta-intel-realsense"
```
3. If you are building an image with a graphical desktop you can add the following to `conf/auto.conf`
```bitbake
    CORE_IMAGE_EXTRA_INSTALL += "librealsense-graphical-examples"
```

License
=======
Copyright 2016 Intel Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
```bitbake
	 http://www.apache.org/licenses/LICENSE-2.0
```
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

