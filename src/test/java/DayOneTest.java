import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DayOneTest {
@Test
    public void helloWorldText1(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com");
   Assert.assertEquals("Google gdfshsdfgh", driver.getTitle());
    }

    @Test
    public void googleSearch()throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement googleSearchField = driver.findElement(By.name("q"));
        WebElement googleSearchBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        //accept google T&Cs
        driver.findElement(By.id("L2AGLb")).click();

        googleSearchField.sendKeys("Movies 2022");
        Thread.sleep(5000);
        googleSearchBtn.click();
        String machingWord = driver.findElement(By.className("iKJnec")).getText();
        Assert.assertEquals("Box office", machingWord);
    }

    @Test
    public void login(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        login(driver);
    }

    private void login(WebDriver driver) {
        WebElement username = driver.findElement(By.name("q"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        WebElement submitbutton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));

        username.sendKeys("asdfgasfdg");
        password.sendKeys("asdfgasfdg");
        submitbutton.click();
        Assert.assertEquals("Box office", "asdfgasdfg");
    }

    @Test
    public void sendMessage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        login(driver);
       driver.get("asdfg");

    }

}
