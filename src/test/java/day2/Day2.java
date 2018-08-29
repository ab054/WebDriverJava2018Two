package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        By searchInput = By.cssSelector("#lst-ib");
        waitFor(searchInput);
        sendKeysTo(searchInput);
        sleepFor(5);
    }

    private void sleepFor(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    private void waitFor(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    private void sendKeysTo(By element){
        WebElement webElement = driver.findElement(element);
        webElement.sendKeys("Portnov");
        webElement.submit();
    }
}
