# build-selenium-test
Test Assessment for Build.com Automation Engineers

Basic Requirements: 
* Clone this repository to your local machine 
* Complete the unimplemented @Tests in BuildTest.java to the best of your abilities while using Java and Selenium. If you can't complete each @Test, that is OK, just show us what you can do.
* Correctly use Page Objects and AssertJ to the best of your abilities.
* Make sure the code compiles without issue when running "mvn test", and that all tests pass. 
* Upload completed assessment to your own repository and share the link to your repository so we can review your code.

Bonus points:
* Make the tests work with multiple browsers (Chrome, Safari, etc.)

More bonus points (be impressive):
* Make the tests work with Appium: using Safari on iOS and/or Chrome on Android. 

Notes:
* Ignore/skip CAPTCHA page (if encountered), submit code as if it does not exist or wait for user to complete it.
* Take your time.


Complete Things:

* Appium has been integrated into the tests for Safari on iOS and Chrome on Android
* Tests will run in various browser like Safari, Chrome, Firefox
* All the test are completed


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
