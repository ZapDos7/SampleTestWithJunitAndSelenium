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
    public void searchTest() throws InterruptedException {
        TutorialsPointPage tutorialsPointPageObject = PageFactory.initElements(driver, TutorialsPointPage.class);
        tutorialsPointPageObject.search(SEARCH_TERM);
        Thread.sleep(1000);
        tutorialsPointPageObject.click();

        Assert.assertTrue(tutorialsPointPageObject.getSearchText().contains(SEARCH_TERM));
        Assert.assertEquals(6, tutorialsPointPageObject.getLoadText().chars().filter(ch -> ch == '€').count());
        Assert.assertEquals(tutorialsPointPageObject.getGridSize(), 3);
        Thread.sleep(1000);
    }
}
