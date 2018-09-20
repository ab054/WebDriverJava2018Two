package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Login extends BaseTest{

    @Test
    public void testLogin() {
        String url = "http://52.9.182.211:3001/v1/log-in";
        String restID = "Rest_005";
        String password = "12345678";
        String email = "Rest_005@gmail.com";

        navigateToTheURL(url);
        waitFor(LoginPage.submitButton);
        enterCredentials(restID, password, email);
        clickSubmit();
        waitFor(LoginPage.logoutButton);

        Assert.assertTrue(isVisible(LoginPage.logoutButton));
    }

    private void clickSubmit() {
        driver.findElement(LoginPage.submitButton).click();
    }

    private void enterCredentials(String restID, String password, String email){
        sendKeysTo(LoginPage.restID, restID);
        sendKeysTo(LoginPage.password, password);
        sendKeysTo(LoginPage.email, email);
    }
}