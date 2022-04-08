import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import packageobjects.PlaygroundPage;

public class DayTwoTest {
    //2nd day notes
    private final static String url = "http://seleniumplayground.vectordesign.gr/selector-playground/";
    private WebDriver webDriver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    @After
    public void finish() {
        //method `close()` does not shut down the entire testing process, `quit()` quits the entire process
        webDriver.quit();
    }

    @Test
    public void test1() {
        webDriver.findElement(By.id("id-playground-field")).sendKeys("ID selector");
        webDriver.findElement(By.name("name-playground-field")).sendKeys("Name selector");
        webDriver.findElement(By.className("class-playground-field")).sendKeys("Class selector");
        webDriver.findElement(By.cssSelector(".css-playground-field")).sendKeys("CSS selector");
//        webDriver.findElement(By.xpath("//html/body/div/div[2]/div[2]/form/div[2]/div[4]/input")).sendKeys("XPath selector");
        webDriver.findElement(By.tagName("textarea")).sendKeys("Text Tag selector");
    }

    @Test
    public void enterText() {
        PlaygroundPage playgroundPageObjects = PageFactory.initElements(webDriver, PlaygroundPage.class);
        playgroundPageObjects.typeIdTextField("some id");
        playgroundPageObjects.typeNameTextField("some name");
    }
}
