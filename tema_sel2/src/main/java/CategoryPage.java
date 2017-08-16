import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }

    //Finds the result that contains the title
    @FindBy(xpath = "//div[@id='main_products_container']/ul/li/div[3]/p/a")
    private List<WebElement> customMobileTitle;

    CustomProductPage searchItem(String productName){

        for (WebElement mobileTitle : customMobileTitle ) {
            if (mobileTitle.getText().equals(productName)) {
                mobileTitle.click();

                CustomProductPage customProductPage = PageFactory.initElements(driver, CustomProductPage.class);
                return customProductPage;
            }
        }
        return null;
    }

    public void waitUntilCompleteLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(customMobileTitle));
    }
}
