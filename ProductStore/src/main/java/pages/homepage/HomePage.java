package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.productpage.ProductPage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By products = By.xpath("//h4[@class='card-title']");

    public ProductPage pressOnAnyProduct() {
        driver.findElements(products).get((int) (Math.random() * 9)).click();
        return new ProductPage(driver);
    }
}
