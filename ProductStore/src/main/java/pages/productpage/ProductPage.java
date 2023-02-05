package pages.productpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartBut = By.xpath("//a[text()='Add to cart']");

    public ProductPage pressAddToCart() {
        driver.findElement(addToCartBut).click();
        waitAlertIsPresent();
        driver.switchTo().alert().accept();
        return this;
    }
}
