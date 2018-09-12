package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrames extends BaseTest{

    @Test
    public void testNestedFrames() {
        String url = "http://the-internet.herokuapp.com/nested_frames";

        driver.get(url);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String textfromMiddleFrame = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(textfromMiddleFrame, "MIDDLE");
    }

    @Test
    public void testIFrames(){
        String url = "http://the-internet.herokuapp.com/tinymce";

        driver.get(url);

        driver.switchTo().frame("mce_0_ifr");

        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("dfsgsdfgsdf");

        //switch back
        driver.switchTo().defaultContent();

       String textFromTheHeader = driver.findElement(By.cssSelector("#content > div > h3")).getText();

       Assert.assertEquals(textFromTheHeader, "An iFrame containing the TinyMCE WYSIWYG Editor");


    }
}
