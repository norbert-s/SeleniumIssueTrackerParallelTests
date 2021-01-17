# Testing issue tracker by running Selenium tests - E2E tests



Freecodecamp project of issuetracker is tested here with Java Selenium

Here parallel testing is solved with the browser closed and the webdriver quit, after every test.

Also by another driver being created for every test.

If it is not a necessity to be closing the webdriver , but only to clean the cache, then only a thread pool needs to be created with a particular number of drivers passed around after use.







The project tested here is available at: https://issue-tracker-mongo.herokuapp.com/


