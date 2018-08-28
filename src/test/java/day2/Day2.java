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
