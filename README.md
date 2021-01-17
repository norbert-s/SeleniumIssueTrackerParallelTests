# Testing issue tracker by running Selenium tests - E2E tests



Freecodecamp project of issuetracker is tested here with Java Selenium

Here parallel testing is solved, however it is not the final version, because webdiriver are called in the functions, instead of having by injecting the new webdriver objects. 

Based on the book written by Mark Collin(Mastering selenium webdriver 3.0) the final version is refactored and the webdriver objects are correctly taken from a threadpool of webdrivers.

Here the tests work, although still not in line with OOP and Solid desing principles.



The project tested here is available at: https://issue-tracker-mongo.herokuapp.com/


