## Sample Testing Application

### Premise

During the course of the [Quality Assurance and Testing ReGeneration Academy](https://www.regeneration.gr/en/regen-academy/4women-in-software-quality-assurance-testing/), we were instructed to think of a scenario where we would search for an element in a webpage and we should verify that a certain element would be displayed on screen.

The project was implemented in Ubuntu 18.04, using IntelliJ, and the test environment is a Google Chrome browser.

### Scenario:
- We search for `JUnit` in TutorialsPoint.
- We expect the search to yield a list of items with the keyword `JUnit` as well as 3 courses/ebooks (as of April, 2022) , with their corresponding price.
- For this reason, we enter the webpage, type `JUnit` in the searchbar and press enter.
- The end result should contain a list of elements. This list should on top display a String with the search term, aka `JUnit`, and the list elements should contain the `€` symbol, as these courses are not free. This symbol should be displayed 6 times, 2 per course/ebook, as the text displays each course's price and saving amount.

### Technologies Used
- Java 17
- [Selenium](https://www.selenium.dev/)
- [bonigarcia's Web Driver Manager](https://github.com/bonigarcia/webdrivermanager)

Instructor: [T. Lagonikas](https://www.linkedin.com/in/theodore-lagonikas/?trk=org-employees&originalSubdomain=gr)

### Notes

#### Day 1
- We setup a driver according to the test browser we use
- `findElement(by...)` in order to find the DOM element of the HTML page (by: id, class, css selector etc)
- `xpath` can be easily broken so it is not optimal in each case, use with caution

#### Day 2
- Better organisation with `packageobjects` POM classes: We use the same `findBy` means to get an item from our HTML page, however this is more volatile: in case the element is renamed in the HTML code, we need only change the corresponding annotation in our `packageobjects` class.
- It is best to use `@Before` and `@After` above methods in order to define functionality done before and after each test session.
- In larger test sessions especially, it is crucial to `webDriver.quit();` in order to ease the load of the testing machine.
- Method `close()` does not shut down the entire testing process, `quit()` quits the entire process