Sample project for an ecommerce website build.com
Assumptions:

* All the Webdrivers should be added to the system path
* For running Appium test, the Appium server should be started and the corresponding emulator or real device should be connected
* For for running on different Mobile devices a Config file should be created with the same format as seen in the CONFIG folder with the capabilities in the same format
* The test compiles by reading the parameter values form the system arguments
* For running test in Mobile iOS the Safari Master project should be build and run in the corresponding emulator


Running the test:

* The test can be run in different browser by changing the "-DBROWSER" argument with the corresponding browsers like chrome, safari, firefox
Example: mvn test -DBROWSER=chrome

* The test can be run in mobile browser with the following command
Example:  mvn test -DCONFIG=android_nexus5.properties
If you want to run in iOS use ios-iphone6s.properties
