package hu.masterfield.POMAndPageFactory.Feladat02;

import hu.masterfield.POMAndPageFactory.Feladat02.pageFactory.LoginPagePF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPF extends BaseTest{
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test
    public void testLoginOXPOM() throws InterruptedException {
        LoginPagePF loginPF = new LoginPagePF(driver);
        loginPF.open();
        loginPF.setUserName(userName);
        loginPF.setUserPassword(password);
        loginPF.clickLoginButton();
        assertTrue(loginPF.checkLoginSuccess());
        Thread.sleep(3000);
    }
}
