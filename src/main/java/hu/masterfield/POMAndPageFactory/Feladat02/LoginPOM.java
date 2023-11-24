package hu.masterfield.POMAndPageFactory.Feladat02;

import hu.masterfield.POMAndPageFactory.Feladat02.pom.LoginPagePOM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPOM extends BaseTest{
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test
    public void testLoginOXPOM() throws InterruptedException {
        LoginPagePOM loginPOM = new LoginPagePOM(driver);
        loginPOM.open();
        loginPOM.setUserName(userName);
        loginPOM.setUserPassword(password);
        loginPOM.clickLoginButton();
        assertTrue(loginPOM.checkLoginSuccess());
        Thread.sleep(3000);
    }
}
