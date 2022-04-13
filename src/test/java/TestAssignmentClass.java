import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import packageobjects.TutorialsPointPage;

public class TestAssignmentClass {

    public static final String SEARCH_TERM = "JUnit";
    public static final String URL = "https://www.tutorialspoint.com/index.htm";
    public static final String TITLE = "Biggest Online Tutorials Library";
    public static final int times = 3;

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Setting up test environment.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void after() {
        System.out.println("Finished testing, cleanup.");
        driver.quit();
    }

    @Test
    public void titleTest() {
        Assert.assertEquals(TITLE, driver.getTitle());
        Assert.assertNotEquals("YouTube", driver.getTitle());
    }

    @Test
    public void searchTest() {
        TutorialsPointPage tutorialsPointPageObject = PageFactory.initElements(driver, TutorialsPointPage.class);
        driver.manage().window().maximize(); //.fullscreen() doesn't work properly in Chrome, but works in FireFox
        tutorialsPointPageObject.search(SEARCH_TERM);
        tutorialsPointPageObject.click();

        Assert.assertTrue(tutorialsPointPageObject.getSearchText().contains(SEARCH_TERM));
        //Assert.assertEquals(2*times, tutorialsPointPageObject.getLoadText().chars().filter(ch -> ch == '€').count());
        //this test will fail when the UI changes and the euro sign is displayed more than twice per item in the grid, so we should not use this as a test
        Assert.assertEquals(tutorialsPointPageObject.getGridSize(), times);
    }
}
