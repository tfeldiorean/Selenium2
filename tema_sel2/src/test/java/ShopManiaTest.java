import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ShopManiaTest {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void shopIphone() throws InterruptedException {
        ResultsPage resultsPage = homePage.searchItem("iphone");
        CategoryPage categoryPage = resultsPage.resultCategory("Telefoane mobile");
        CustomProductPage customProductPage = categoryPage.searchItem("Telefon mobil Apple iPhone SE 16GB, iOS");
        customProductPage.getAvailableShops();
        customProductPage.listTotalProducts();
    }

    @Test
    public void shopParfumuri() throws InterruptedException {
        ResultsPage resultsPage = homePage.searchParfumuri();
        resultsPage.resultProduct();

    }
}
