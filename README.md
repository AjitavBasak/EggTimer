# EggTimer
The Automation framework is simple and easy to maintain.
1. I have used BDD framework with the help of Cucumber
2. A property file has been created for all the generic configuration for the project under resources module of main
3. Created a object repository of Elements in a property file with few conventions.
   
       a. file name is same as the url with all special character replaced with '_'.
   
       b. The UI objects/elements are given an identifier matching the functionality of the object/element.
   
       c. The value of the element in the property file has 2 details
   
          i.  locator Type
   
          ii. locator value
          The 2 values are seperated by a delimeter '::::' and if in any unforseen case the delimeter becomes part of the value in future it has been handled to inform the tester to change the delimeter in case of such circumstance
4. For logging all the details  I have used log4j whose property file is also placed under resources.
5. All the config properties are loaded and can be read from PropertyReader.
6. All the objects in property file are converted to webElement in LoadObjectAndGetWebElement class.
7. The WebDriver designed using singleton design pattern.
8. All the WebDriver action to be performed is wrapped in UIElementAction class making it easy to reuse and the need of driver moving around in classes reduced to      only a framework thing making the tester not worry about it.
9. TestRunner class is the entry point
10. All the features(human readable gherkin statements ) are placed in resources module under test
11. The package is maintained to be reverse domain i.e. com.eggtimer
12. The control moves from feature file to the step defination classes placed in test/com.eggtimer.Steps 
13. Every Step will have a page which has the implementation using the wrappers mentioned above.
14. All the wrappers are placed under utils
