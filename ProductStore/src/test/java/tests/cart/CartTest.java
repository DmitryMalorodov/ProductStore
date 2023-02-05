package tests.cart;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.HOME_PAGE;

@Epic(value = "Корзина")
@Owner(value = "Малородов Дмитрий")
public class CartTest extends BaseTest {

    @Test
    @Description(value = "Проверка добавления товара в корзину")
    public void checkAddProductToCart() {
        basePage.open(HOME_PAGE);

        homePage.pressOnAnyProduct()
                .pressAddToCart();

        basePage.pressCart()
                .checkExistProductInCart();
    }
}
