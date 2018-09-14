package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static By restaurantIDInput = By.name("restaurant_id"); //By.cssSelector("div.MuiFormControl-root-96:nth-child(2) > div:nth-child(2) > input:nth-child(1)");
    public static By emailInput = By.name("email"); //By.cssSelector("div.MuiFormControl-root-96:nth-child(3) > div:nth-child(2) > input:nth-child(1)");
    public static By passwordInput = By.name("password"); //By.cssSelector(".MuiInput-inputType-121");
    public static By logoutButton = By.cssSelector(".MuiButtonBase-root-83");
    public static By submitButton = By.cssSelector(".MuiButton-root-127");
}
