package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class NestedFrames extends BaseTest {

    @Test
    public void testIframes() throws Exception {
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();

        assertNotEquals(afterText, beforeText);

        driver.switchTo().defaultContent();

        assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(),
                "An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    @Test
    public void nestedFrames() {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");


        assertEquals(driver.findElement(By.id("content")).getText(), "MIDDLE");
    }
}