package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cartpage.CartPage;
import pages.homepage.HomePage;

import java.time.Duration;
import java.util.List;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By homeBut = By.xpath("//a[text()='Home ']");
    private By cartBut = By.xpath("//a[text()='Cart']");

    public void open(String url) {
        driver.get(url);
    }

    public HomePage pressHome() {
        driver.findElement(homeBut).click();
        return new HomePage(driver);
    }

    public CartPage pressCart() {
        driver.findElement(cartBut).click();
        return new CartPage(driver);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public List<WebElement> waitElementsAreVisible(List<WebElement> elements) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public void waitAlertIsPresent() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.alertIsPresent());
    }
}
