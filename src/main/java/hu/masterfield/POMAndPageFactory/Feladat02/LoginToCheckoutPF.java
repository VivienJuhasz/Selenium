package hu.masterfield.POMAndPageFactory.Feladat02;

import hu.masterfield.POMAndPageFactory.Feladat02.pageFactory.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginToCheckoutPF extends BaseTest{
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test
    public void testLoginOXPOM() throws InterruptedException {
        LoginPagePF loginPF = new LoginPagePF(driver);
        ProductPagePF productPF = new ProductPagePF(driver);
        CartPagePF cartPF = new CartPagePF(driver);
        CheckoutPF checkoutPF = new CheckoutPF(driver);
        CheckoutOverviewPF checkoutOverviewPF = new CheckoutOverviewPF(driver);

        loginPF.open();
        loginPF.setUserName(userName);
        loginPF.setUserPassword(password);
        loginPF.clickLoginButton();
        assertTrue(loginPF.checkLoginSuccess());
        Thread.sleep(3000);

        String[] expectedProducts = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
        assertTrue(productPF.checkItems(expectedProducts));

        productPF.addToCartBackpack();
        productPF.addToCartBikeLight();
        productPF.addToCartBoltTShirt();
        productPF.addToCartFleeceJacket();
        productPF.addToCartTShirtRed();
        productPF.addToCartLabsOnesie();

        productPF.goToShoppingCart();
        assertTrue(productPF.checkGoToCartSuccess());
        Thread.sleep(3000);

        cartPF.checkCartItemsNumber(6);
        cartPF.goToCheckoutYourInformation();
        assertTrue(cartPF.checkGoToCheckoutYourInformationSuccess());
        Thread.sleep(3000);

        checkoutPF.fillFirstName("Peter");
        checkoutPF.fillLastName("Racz");
        checkoutPF.fillPostalCode("1213");
        checkoutPF.goToCheckoutOverview();
        assertTrue(checkoutPF.checkGoToCheckoutOverviewSuccess());
        Thread.sleep(3000);

        String[] expectedProductsInCart = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie"};
        assertTrue(checkoutOverviewPF.checkItems(expectedProductsInCart));
        assertTrue(checkoutOverviewPF.checkTax(10.40));
        assertEquals(129.94, checkoutOverviewPF.checkSubPrice());
        assertEquals(129.94, checkoutOverviewPF.checkFullPrice());
        checkoutOverviewPF.goToCheckoutComplete();
        assertTrue(checkoutOverviewPF.checkGoToCheckoutComplete());
        Thread.sleep(3000);
    }
}
