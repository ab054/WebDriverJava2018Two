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

    //create a class field
    WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        //set path to gecko driver
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");

        //create instance of Firefox
        driver = new FirefoxDriver();
    }

    @Test
    public void testGoogleSearch() {
        //create object of By class using cssSelector
        By searchInputByCss = By.cssSelector("#lst-ib");

        //string for search in Google
        String searchString = "Portnov";

        //url
        String googleURL = "http://google.com";

        //navigate to URL
        driver.get(googleURL);

        //wait for element to be presented
        waitFor(searchInputByCss);

        //sleep for 2 seconds
        sleepFor(2);

        //type into search our string
        sendKeysTo(searchInputByCss, searchString);
    }

    private void sendKeysTo(By element, String charSequence){
        //create webElement object by using findElement() which receives element
        WebElement webElement = driver.findElement(element);

        //type charSequence
        webElement.sendKeys(charSequence);

        //submit results
        webElement.submit();
    }

    private void waitFor(By element){
        //create object wait with field driver and 10 seconds of timeout
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait until element will presented on the page
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    //after test phase
    @AfterTest
    public void afterTest(){
        sleepFor(5);
        driver.close();
    }

    private void sleepFor(int i) {

        //try catch block Java
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
