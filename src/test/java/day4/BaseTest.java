package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Set;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


    public void navigateToTheURL(String url) {
        driver.get(url);
        waitForPageLoaded();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                    ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                        }
                    };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void clickOntheLink(String text) {
        WebElement element = driver.findElement(By.linkText(text));
        element.click();
    }

    public static void sleepFor(int i) {
        //try catch block Java
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchOverToNewWindow(String originalHandle){
        sleepFor(1);
        for(String each : driver.getWindowHandles()){
            if(!each.contains(originalHandle)){
                driver.switchTo().window(each);
            }
        }
    }

    public void assertThatTextIsPresented(String expectedText) {
        String pageSource = driver.getPageSource();
        boolean isPresented = pageSource.contains(expectedText);
        Assert.assertTrue(isPresented);
    }

    public void printOutAllTheTitles() {
        Set<String> handles = driver.getWindowHandles();
        for(String eachHandle :  handles){
            driver.switchTo().window(eachHandle);
            System.out.println(driver.getTitle());
        }
    }

    public void closeLastOpenedWindow() {
        driver.close();
    }

}