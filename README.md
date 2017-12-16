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


Assumptions:

Webdrivers should be added to the system path
For running mobile test Appium servers should be started and the corresponding emulator or real device should be connected



Running the test:


mvn test -DBROWSER=chrome

mvn test is phase of Maven lifecycle(google it)

Parameters: 

-D

parametrs are added into System arguments


Read the parameters value from the system arguments 
