package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static By submitButton = By.cssSelector(".MuiButton-root-127");
    public static By restID = By.name("restaurant_id");
    public static By email = By.name("email");
    public static By password = By.name("password");
    public static By logoutButton = By.cssSelector(".MuiButtonBase-root-83");
}
