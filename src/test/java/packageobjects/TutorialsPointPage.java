package packageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TutorialsPointPage {
    @FindBy(id = "search-strings")
    private WebElement searchStrings;

    @FindBy(id = "btnSearch")
    private WebElement searchButton;

    @FindBy(id = "search_value")
    private WebElement searchResultsTitle;

    @FindBy(id = "load")
    private WebElement searchResultsLoad;

    @FindBy(xpath = "//*[@id=\"ebooks_grid\"]/div")
    private List<WebElement> gridXpath;

    public TutorialsPointPage search(String text) {
        searchStrings.sendKeys(text);
        return this;
    }

    public TutorialsPointPage click() {
        searchButton.click();
        return this;
    }

    public String getSearchText() {
        return searchResultsTitle.getText();
    }

    public String getLoadText() {
        return searchResultsLoad.getText();
    }

    public int getGridSize() {
        return gridXpath.size();
    }

    public TutorialsPointPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
