import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestAssignmentClass {

    public static final String SEARCH_TERM = "JUnit";
    public static final String URL = "https://www.tutorialspoint.com/index.htm";
    public static final String TITLE = "Biggest Online Tutorials Library";

    @Before
    public void setUp() {
        System.out.println("Before each test.");
    }

    @After
    public void after() {
        System.out.println("After each test.");
    }

    @Test
    public void simpleTest() {
        //set up driver for chrome
        //the driver gives us access to all selenium actions
        WebDriverManager.chromedriver().setup();
        //if we wish to test in firefox, instead we use the following:
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        Assert.assertEquals(TITLE, driver.getTitle());
        Assert.assertNotEquals("YouTube", driver.getTitle());
    }

    @Test
    public void testYouTubeSearch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(URL);
        WebElement searchField = driver.findElement(By.id("search-strings"));
        searchField.sendKeys(SEARCH_TERM);
        WebElement buttonSearch = driver.findElement(By.id("btnSearch"));
        buttonSearch.click();

        WebElement searchValueSpan = driver.findElement(By.id("search_value"));
        String searchValueTest = searchValueSpan.getText();
        Assert.assertTrue(searchValueTest.contains(SEARCH_TERM));

        WebElement searchLoad = driver.findElement(By.id("load"));
        Assert.assertEquals(6, searchLoad.getText().chars().filter(ch -> ch == '€').count());

        //we should not forget this, especially in larger scale testing processes
//        driver.quit();

        List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"ebooks_grid\"]/div"));
        Assert.assertEquals(results.size(), 3);
//        Thread.sleep(3000);
    }
}
