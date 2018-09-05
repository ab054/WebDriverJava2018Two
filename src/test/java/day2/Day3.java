package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static day2.Day2.sleepFor;

public class Day3 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        //set path to gecko driver
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");

        //create instance of Firefox
        driver = new FirefoxDriver();
    }

    @Test
    public void windows() {
        driver.get("http://the-internet.herokuapp.com/windows");

        By link = By.linkText("Click Here");

        String parentHandle = driver.getWindowHandle();

        driver.findElement(link).click();

        System.out.println(driver.getCurrentUrl());

        sleepFor(3);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        boolean isNewWindowExists = driver.getPageSource().contains("New Window");

        driver.close();
        driver.switchTo().window(parentHandle);
    }

    @Test
    public void testCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        By checkbox1 = By.cssSelector("#checkboxes > input:nth-child(1)");

        waitFor(checkbox1, 3);

        System.out.println(getAttribute(checkbox1, "checked"));

        click(checkbox1);

        Assert.assertNotNull(getAttribute(checkbox1, "checked"));

        Assert.assertTrue(isSelected(checkbox1));

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input"));

        WebElement checkBox1 = checkBoxes.get(0);
        WebElement checkBox2 = checkBoxes.get(1);
    }

    private boolean isSelected(By checkbox) {
        return driver.findElement(checkbox).isSelected();
    }

    public String getAttribute(By element, String attribute) {
        return driver.findElement(element).getAttribute(attribute);
    }

    private void waitFor(By element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    private void click(By element) {
        driver.findElement(element).click();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
