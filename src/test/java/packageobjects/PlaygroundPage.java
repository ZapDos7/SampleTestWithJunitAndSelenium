package packageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaygroundPage {
    @FindBy(id = "id-playground-field")
    private WebElement idTextField;

    @FindBy(name = "name-playground-field")
    private WebElement nameTextField;

    public PlaygroundPage typeIdTextField(String text) {
        idTextField.sendKeys(text);
        return this;
    }

    public PlaygroundPage typeNameTextField(String text) {
        nameTextField.sendKeys(text);
        return this;
    }

    //... etc

    public PlaygroundPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
