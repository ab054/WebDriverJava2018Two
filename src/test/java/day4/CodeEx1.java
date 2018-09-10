package day4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeEx1 {

    @DataProvider(name = "stings")
    public Object[][] createData1() {
        return new Object[][] {
                { "madam" },
                { "Adaanaada" },
        };
    }

    @Test(dataProvider = "stings")
    public void testIsPalindrome(String input) {
        //String input = "madam";
        String reversed = reverseString(input);
        Assert.assertEquals(input, reversed);
    }

    @Test
    public void testIsReversed02() {
        String input = "madam3";
        String reversed = reverseString(input);
        Assert.assertEquals(input, reversed);
    }

    private String reverseString(String input) {
        return new StringBuffer(input).reverse().toString();
    }
}
