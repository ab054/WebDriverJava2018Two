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
import java.util.concurrent.TimeUnit;


public class Day2 {

    WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://google.com");
        //wait(5);

        By searchInput = By.cssSelector("#lst-ib");
        By searchInputX = By.xpath("//*[@id=\"lst-ib\"]");

        waitFor(searchInputX, 5);
        driver.findElement(searchInputX).sendKeys("Portnov");
        driver.findElement(searchInputX).submit();
        sleep(5);
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

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type=\"Checkbox\"]"));

        WebElement checkBox1 = checkBoxes.get(0);
        WebElement checkBox2 = checkBoxes.get(1);
    }

    private boolean isSelected(By checkbox) {
       return driver.findElement(checkbox).isSelected();
    }

    public String getAttribute(By element, String attribute) {
        return driver.findElement(element).getAttribute(attribute);
    }

    private void click(By element) {
        driver.findElement(element).click();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void wait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    private void waitFor(By element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
