package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static day2.Day2.sleepFor;

public class Day3 {

    WebDriver driver;


    @Test
    public void testWindows() {
        String url = "http://the-internet.herokuapp.com/windows";
        By link = By.linkText("Click Here");
        String textToBeChecked = "New Window";

        setupBrowser();
        navigateToURL(url);
        clickOnLink(link);
        sleepFor(3);
        assertTextPresented(textToBeChecked);
        printOutAllTitles();
        closeLastWindowOpened();
    }

    private void closeLastWindowOpened() {
        driver.close();
    }

    private void printOutAllTitles() {
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

    private void assertTextPresented(String textToBeChecked) {
        boolean isTextPresented = driver.getPageSource().contains(textToBeChecked);
        Assert.assertTrue(isTextPresented);
    }

    private void clickOnLink(By element) {
        driver.findElement(element).click();
    }

    private void navigateToURL(String url) {
        driver.get(url);
    }

    @BeforeTest
    private void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterTest
    private void afterTest(){
        driver.quit();
    }
}
