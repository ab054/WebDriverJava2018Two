package day4;

import org.testng.annotations.Test;

public class WindowsHandlesTest extends BaseTest{

    @Test
    public void testName() {
        String url = "http://the-internet.herokuapp.com/windows";
        String expectedText = "New Window";
        String linkText = "Click Here";

        navigateToTheURL(url);
        String originalHandle = driver.getWindowHandle();
        clickOntheLink(linkText);
        switchOverToNewWindow(originalHandle);
        waitForPageLoaded();
        assertThatTextIsPresented(expectedText);
        printOutAllTheTitles();
        closeLastOpenedWindow();
    }
}