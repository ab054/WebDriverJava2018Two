package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrames extends BaseTest{

    @Test
    public void testIFrames() {
        String url = "http://the-internet.herokuapp.com/tinymce";

        navigateToTheURL(url);

        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));

        editor.clear();

        String text = "My Text from Test";

        editor.sendKeys(text);

        Assert.assertEquals(editor.getText(), text);
    }



    @Test
    public void testNestedFrames() {
        String url = "http://the-internet.herokuapp.com/nested_frames";

        navigateToTheURL(url);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String middleContent = driver.findElement(By.id("content")).getText();

        Assert.assertEquals(middleContent, "MIDDLE");

    }
}
