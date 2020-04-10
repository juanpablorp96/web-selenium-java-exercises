package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class NyTimesHomePage extends BasePage {

    @FindBy(id = "desktop-sections-button")
    private WebElement sectionsButton;

    @FindBy(className = "css-1u2uo3y")
    private List<WebElement> sectionsList;

    @FindBy(className = "css-10488qs")
    private WebElement searchButton;

    @FindBy(name = "query")
    private WebElement searchField;

    /**
     * Constructor.
     */
    public NyTimesHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to fill out the search field.
     *
     */
    public void search(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearch(){
        searchField.submit();
    }

    public void waitToSee(){
        getWait().until(ExpectedConditions.visibilityOf(sectionsButton));
    }

    public void click(){
        getWait().until(ExpectedConditions.elementToBeClickable(sectionsButton));
        click(sectionsButton);
    }

    public List<WebElement> getCurrentSections(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(sectionsList));
        return sectionsList;
    }

    public void waitSearchIcon(){
        getWait().until(ExpectedConditions.visibilityOf(searchButton));
    }

    public void clickSearchIcon(){
        getWait().until(ExpectedConditions.elementToBeClickable(sectionsButton));
        click(searchButton);
    }
}
