package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.NyTimesHomePage;
import pages.QueryResultPage;
import utils.enums.Data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MyStepsDefinition {

    /*
    Terminal:
    $ ./chromedriver
        Starting ChromeDriver 76.0.3809.68 (...) on port 9515
        ...
     */
    ChromeOptions chromeOptions;

    private WebDriver driver;
    private NyTimesHomePage nyTimesHomePage;
    private QueryResultPage queryResultPage;

    public MyStepsDefinition() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless", "start-maximized", "window-size=1920,1080");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), chromeOptions);
    }
    //private final WebDriver driver = new FirefoxDriver();

    @Given("I am on the New York Times home page$")
    public void I_visit_nytimes() {
        driver.get("https:\\www.nytimes.com/");
        nyTimesHomePage = new NyTimesHomePage(driver);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void search_for(String query) {
        nyTimesHomePage.search(query);
        nyTimesHomePage.clickSearch();
        queryResultPage = new QueryResultPage(driver);
    }

    @Then("^the page title should start with \"([^\"]*)\"$")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
            }
        });
    }

    @Then("I should see the sections button")
    public void iShouldSeeTheElement() {
        nyTimesHomePage.waitToSee();
    }

    @When("I click on the sections button")
    public void iClickOnTheElement() {
        nyTimesHomePage.click();
    }

    @Then("I should see the correct sections")
    public void iShouldSeeTheCorrectSections() {
        List<WebElement> currentSections = nyTimesHomePage.getCurrentSections();
        List<String> expectedSections = nyTimesHomePage.getExpectedSections();
        List<String> currentSectionsText = new ArrayList<>();
        for(WebElement section : currentSections){
            currentSectionsText.add(section.getText());
        }
        Assert.assertEquals(currentSectionsText, expectedSections);
    }

    @And("I should see the search icon")
    public void iShouldSeeTheSearchIcon() {
        nyTimesHomePage.waitSearchIcon();
    }

    @When("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        nyTimesHomePage.clickSearchIcon();
    }

    @And("I select sort by {string}")
    public void iSelectSortBy(String option) {
        queryResultPage.selectSortBy(option);
    }

    @Then("I should see {string} in the result page")
    public void iShouldSeeInTheResultPage(String query) {
        Assert.assertEquals(queryResultPage.getQuery(), query);
    }

    @After()
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }
}
