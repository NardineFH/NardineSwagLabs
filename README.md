# This project is about testing Swag app mobile App using Appium.
## This project has 5 test cases and six pages and four action classes.
### Development Setting 
1. It has one helper class for mobile action and other for reading data from external file.
2. Automated report is implemented using shaft allure reporting.
3. Other report is implemented using testNg report.
4. Screenshot is attached to report provided by shaft.

### Testing Setting(
1. 1st Test case is testing login successfully.
2. 2nd Test case is testing adding items and validating that item was added successfully.
3. 3rd Test case is testing removing product and validating that the item is removed successfully.
4. 4th Test case is testing online shopping and validating that the shopping journey is done successfully.
5. 5th Test case is testing logging with invalid data and validating that error message is appeared successfully.

### Note the logout locator was not interactable so I used Only for groups attribute with @beforMethod to avoid repeating login action in each test.





