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
        By searchInputByCss = By.cssSelector("#lst-ib");
        String searchString = "Portnov";
        String googleURL = "http://google.com";

        driver.get(googleURL);
        waitFor(searchInputByCss);
        sleepFor(2);
        sendKeysTo(searchInputByCss, searchString);
    }

    private void sendKeysTo(By element, String charSequence){
        WebElement webElement = driver.findElement(element);
        webElement.sendKeys(charSequence);
        webElement.submit();
    }

    private void waitFor(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    @AfterTest
    public void afterTest(){
        sleepFor(5);
        driver.close();
    }

    private void sleepFor(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
