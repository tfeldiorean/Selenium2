import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage {

    private WebDriver driver;

    public ResultsPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='nav-cnt cfix']//ul[1]//li//a")
    private List<WebElement> categoryResult;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li[1]/div[3]/a/i")
    private WebElement numberOfStars;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li/div[4]/a")
    private List<WebElement> numberOfOfferts;

    //Click on category Mobile telephones
    public CategoryPage resultCategory(String result) {

        for (WebElement resultElement : categoryResult) {
            if (resultElement.getText().equals(result)) {
                resultElement.click();

                CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
                categoryPage.waitUntilCompleteLoad();
                return categoryPage;
            }
        }
    return null;
    }

    public void resultProduct() {

        //print the number of stars
        System.out.println("Number of stars: " + numberOfStars.getAttribute("class") );

        //verify the number of offerts
        Assert.assertEquals(numberOfOfferts.get(0).getText(), "18 oferte");

        //click on the number of offerts
        numberOfOfferts.get(0).click();
    }

    public void waitUntilCompleteLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(categoryResult));
    }
}
