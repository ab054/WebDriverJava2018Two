package day5;

import day4.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Login extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] dataProvider(){
        return new Object[][]{
                {"Rest_005", "12345678", "Rest_005@gmail.com"},
                {"Rest_005", "12345646", "Rest_005@gmail.com"},
        };
    }

    @Test(dataProvider = "users")
    public void testLogin(String restaurantID, String password, String email) {
        String url = "http://52.9.182.211:3001/v1/log-in";

        navigateToTheURL(url);
        enterCredentials(restaurantID, password, email);
        clickSubmit();

        waitFor(LoginPage.logoutButton);
        Assert.assertTrue(isVisible(LoginPage.logoutButton));
    }

    private void enterCredentials(String restaurantID, String password, String email) {
        sendKeysTo(LoginPage.restaurantIDInput, restaurantID);
        sendKeysTo(LoginPage.emailInput, email);
        sendKeysTo(LoginPage.passwordInput, password);
    }

    private void clickSubmit() {
        driver.findElement(LoginPage.submitButton).click();
    }
}