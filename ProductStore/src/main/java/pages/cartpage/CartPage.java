package pages.cartpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productsInCart = By.xpath("//tr[@class='success']");

    public CartPage checkExistProductInCart() {
        int productsAmount = driver.findElements(productsInCart).size();
        Assert.assertEquals(productsAmount, 1);
        return this;
    }
}
