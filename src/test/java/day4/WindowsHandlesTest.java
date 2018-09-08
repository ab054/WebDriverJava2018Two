package day4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class WindowsHandlesTest extends BaseTest {

    @Test
    public void testWindows() {
        String url = "http://the-internet.herokuapp.com/windows";
        By link = By.linkText("Click Here");
        String textToBeChecked = "New Window";

        navigateToURL(url);
        String originalWindowHandle = driver.getWindowHandle();

        clickOnLink(link);
        switchToLatestWindow(originalWindowHandle);
        waitForLoad();
        assertTextPresented(textToBeChecked);
        printOutAllTitles();
        closeLastWindowOpened();
    }
}