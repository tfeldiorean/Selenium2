import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomProductPage {

    @FindBy(xpath = "//div[@id='product_offers_button']")
    private WebElement availableShops;

    @FindBy(xpath = "//select[@id='offers_sort']/option[2]")
    private WebElement sortByPrice;

    @FindBy(xpath = "//div[@id='product_offers_container']/ul/li/div[2]/div[3]/p[1]")
    private List<WebElement> priceList;

    @FindBy(xpath = "//div[@id='product_offers_container']/ul/li/div[2]/div[2]/p[1]/a")
    private List<WebElement> shopList;

    //Count and print the number of available shops
    public String getAvailableShops() {
        String totalAvailableShops = availableShops.getText();
        System.out.println("The number of available shops is: " + totalAvailableShops + "\n");
        return totalAvailableShops;
    }

    //list products with minimum and maximum price
    public void listTotalProducts() throws InterruptedException {

        sortByPrice.click();
        Thread.sleep(3000);

        String minimumPrice = priceList.get(0).getText();
        String minimumShop = shopList.get(0).getAttribute("title");

        int max = priceList.size() - 1;
        String maximumPrice = priceList.get(max).getText();
        String maximumShop = shopList.get(max).getAttribute("title");

        System.out.println("Minimum price is " + minimumPrice + " for " + minimumShop);
        System.out.println("\n");
        System.out.println("Maximum price is " + maximumPrice + " for " + maximumShop);
    }
}
