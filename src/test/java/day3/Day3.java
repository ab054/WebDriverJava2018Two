package day3;

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

import java.util.Set;

public class Day3 {

    private WebDriver driver;

    @Test
    public void testName() {
        String url = "http://the-internet.herokuapp.com/windows";
        String expectedText = "New Window";

        navigateToTheURL(url);
        clickOntheLink();
        //sleepFor(3); TODO : wait for specific element
        switchOverToNewWindow();
        assertThatTextIsPresented(expectedText);
        printOutAllTheTitles();
        closeLastOpenedWindow();
    }

    @Test
    public void testCheckboxes() {
        //TODO break down into sub steps/methods

        String url = "http://the-internet.herokuapp.com/checkboxes";
        By checkbox1 = By.cssSelector("#checkboxes > input[type=\"checkbox\"]:nth-child(1)");

        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox1));
        driver.findElement(checkbox1).click();
        String isChecked = driver.findElement(checkbox1).getAttribute("checked");
        Assert.assertNotNull(isChecked);
        boolean isSelected =  driver.findElement(checkbox1).isSelected();
        Assert.assertTrue(isSelected);
    }

    private void closeLastOpenedWindow() {
        driver.close();
    }

    private void printOutAllTheTitles() {
        Set<String> handles = driver.getWindowHandles();
        for(String eachHandle :  handles){
            driver.switchTo().window(eachHandle);
            System.out.println(driver.getTitle());
        }
    }

    private void assertThatTextIsPresented(String expectedText) {
        String pageSource = driver.getPageSource();
        boolean isPresented = pageSource.contains(expectedText);
        Assert.assertTrue(isPresented);
    }

    private void switchOverToNewWindow() {
        Set<String> handles = driver.getWindowHandles();
        for(String eachHandle :  handles){
            driver.switchTo().window(eachHandle);
        }
    }

    private void clickOntheLink() {
        WebElement element = driver.findElement(By.linkText("Click Here"));
        element.click();
    }

    private void navigateToTheURL(String url) {

    }

    @BeforeTest
    private void openBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterTest
    private void afterTest(){
        driver.quit();
    }
}