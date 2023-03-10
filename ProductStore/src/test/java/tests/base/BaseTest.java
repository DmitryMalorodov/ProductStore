package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.cartpage.CartPage;
import pages.homepage.HomePage;
import pages.productpage.ProductPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.CLOSE_BROWSER;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected CartPage cartPage = new CartPage(driver);
    protected ProductPage productPage = new ProductPage(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite (alwaysRun = true)
    public void closeBrowser() {
        if (CLOSE_BROWSER) {
            driver.quit();
        }
    }
}
