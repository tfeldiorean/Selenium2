import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://www.shopmania.ro/");
        driver.manage().window().maximize();
    }

    @FindBy(xpath = "//input[@id='autocomplete_prod']")
    private WebElement searchField;

    @FindBy(xpath = "//form[@id='main_search']/div/span[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@id='main_menu_left']/li[4]/a")
    private WebElement hoverOnParfumuri;

//    @FindBy(xpath = "//ul[@id='main_menu_left']/li[4]/div/div/div/div[1]/div/ul/li/a")
//    private List<WebElement> clickOnType;

    @FindBy(xpath = ".//ul[@id='main_menu_left']/li[4]/div/div/div/div[1]/div/ul[2]/li[4]/a")
    private WebElement clickOnType;

    public ResultsPage searchItem(String itemName) {

        searchField.sendKeys(itemName);
        searchButton.click();

        //go to the next page
        ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        resultsPage.waitUntilCompleteLoad();
        return resultsPage;
    }

    public ResultsPage searchParfumuri() {

        Actions action = new Actions(driver);
        action.moveToElement(hoverOnParfumuri).moveToElement(clickOnType).click().build().perform();

        ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        resultsPage.waitUntilCompleteLoad();
        return resultsPage;
    }
}
