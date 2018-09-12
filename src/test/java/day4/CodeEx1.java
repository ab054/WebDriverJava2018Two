package day4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeEx1 {

    @DataProvider(name = "string")
    public Object[][] createData1(){
        return new Object[][] {
                {"madam"},
                {"Madam"},
                {"Madaam"},
        };
    }

    @Test(dataProvider = "string")
    public void testIsPalindrome(String input) {
        input = input.toLowerCase();
        String reversed = reverseString(input);
        Assert.assertEquals(input, reversed);
    }

    private String reverseString(String input) {
        return new StringBuffer(input).reverse().toString();
    }
}
