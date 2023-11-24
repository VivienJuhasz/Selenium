package hu.masterfield.POMAndPageFactory.Feladat02;

import hu.masterfield.POMAndPageFactory.Feladat02.pom.CartPagePOM;
import hu.masterfield.POMAndPageFactory.Feladat02.pom.CheckoutInformationPOM;
import hu.masterfield.POMAndPageFactory.Feladat02.pom.LoginPagePOM;
import hu.masterfield.POMAndPageFactory.Feladat02.pom.ProductPagePOM;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginToCheckoutPOM extends BaseTest{
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test
    public void testLoginOXPOM() throws InterruptedException {
        LoginPagePOM loginPOM = new LoginPagePOM(driver);
        ProductPagePOM productPOM = new ProductPagePOM(driver);
        CartPagePOM cartPOM = new CartPagePOM(driver);
        CheckoutInformationPOM infoPOM = new CheckoutInformationPOM(driver);

        loginPOM.open();
        loginPOM.setUserName(userName);
        loginPOM.setUserPassword(password);
        loginPOM.clickLoginButton();
        assertTrue(loginPOM.checkLoginSuccess());

        productPOM.addToCartAllProducts();
//        productPOM.addToCartBackPack();
//        productPOM.addToCartBoltTShirt();
//        productPOM.addToCartJacket();
//        productPOM.addToCartOnesie();
//        productPOM.addToCartTShirt();
//        productPOM.addToCartBikeLight();
        productPOM.goToShoppingCart();
        assertTrue(productPOM.checkGoToCartSuccess());

        cartPOM.goToCheckoutYourInformation();
        assertTrue(cartPOM.checkGoToCheckoutYourInformationSuccess());

        infoPOM.setFirstName("Peter");
        infoPOM.setLastName("Racz");
        infoPOM.setPostalCode("1213");
        infoPOM.goToCheckoutOverwiev();
        assertTrue(infoPOM.checkGoToCheckoutOverwievSuccess());


        Thread.sleep(3000);
    }
}
