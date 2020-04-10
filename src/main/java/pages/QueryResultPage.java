package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BasePage;

import java.util.List;

public class QueryResultPage extends BasePage {

    @FindBy(className = "css-1dv1kvn")
    private List<WebElement> query;

    @FindBy(className = "css-v7it2b")
    private WebElement selectSortBy;

    /**
     * Constructor.
     * Initialize web elements.
     *
     * @param driver Web driver
     */
    public QueryResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectSortBy(String option){
        Select select = new Select(selectSortBy);
        select.selectByValue(option);
    }

    public String getQuery(){
        return query.get(1).getText();
    }
}
