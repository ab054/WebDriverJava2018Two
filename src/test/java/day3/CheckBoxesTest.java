package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxesTest {

    private WebDriver driver;

    @BeforeTest
    private void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testCheckBoxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)"));

        checkBox1.click();

        String attributeValue = checkBox1.getAttribute("checked");

        Assert.assertNotNull(attributeValue);

        WebElement checkBox2 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)"));

        Assert.assertTrue(checkBox2.isSelected());
    }
}
