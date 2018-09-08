package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    Properties properties = new Properties();

    @BeforeTest
    public void beforeTest(){
        loadProperties("project.properties");

        if(properties.getProperty("operationSystem").contains("Windows"))
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver");
        else
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");

        //create instance of Firefox
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    private void loadProperties(String propertyFileName) {
        FileInputStream propertyFile = null;
        try {
            propertyFile = new FileInputStream(System.getProperty("user.dir") + "/" + propertyFileName);

            properties.load(propertyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateToURL(String url) {
        driver.get(url);
        waitForLoad();
    }

    public void clickOnLink(By element) {
        waitForElement(element);
        driver.findElement(element).click();
    }

    public void assertTextPresented(String textToBeChecked) {
        boolean isTextPresented = driver.getPageSource().contains(textToBeChecked);
        Assert.assertTrue(isTextPresented);
    }

    public void printOutAllTitles() {
        String currentWindowHandle = "";
        String currentWindowTitle = "";

        for(String eachWindowHandle : driver.getWindowHandles()){
            currentWindowHandle = eachWindowHandle;
            driver.switchTo().window(currentWindowHandle);
            currentWindowTitle = driver.getTitle();
            System.out.println(currentWindowTitle);

            //System.out.println(driver.switchTo().window(eachWindowHandle).getTitle());
        }
    }

    public void closeLastWindowOpened() {
        driver.close();
    }

    public void switchToLatestWindow(String originalWindowHandle) {
        sleepFor(1);
        for (String each : driver.getWindowHandles()){
            if (!each.contains(originalWindowHandle)){
                driver.switchTo().window(each);
            }
        }

    }

    public static void sleepFor(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}