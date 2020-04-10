package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.enums.Data;


public class BasePage extends Data {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor.
     * Initialize web elements.
     * @param driver Web driver
     */
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait(){
        return wait;
    }

    /**
     * Click on a web element and log the action.
     * @param element Web element.
     */
    protected void click(WebElement element) {
        element.click();
    }

    /**
     *Fill out a field with a value.
     * @param element Web element.
     * @param data Value to send.
     */
    protected void sendKeys(WebElement element, String data) {
        element.sendKeys(data);
    }
}
