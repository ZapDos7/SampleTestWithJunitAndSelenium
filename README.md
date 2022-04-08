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