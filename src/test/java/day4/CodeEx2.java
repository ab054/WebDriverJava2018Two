package day4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeEx2 {

    @DataProvider(name = "strings")
    public Object[][] createData1(){
        return new Object[][] {
                {"madam"},
                {"fsdfasdf"},
        };
    }

    @Test(dataProvider = "strings")
    public void testIsPalyndrome(String parameter) {
        String input = parameter;
        String reversed = "";

        reversed = reverseString(input);

        Assert.assertEquals(input, reversed);
    }



    private String reverseString(String input) {
        return new StringBuffer(input).reverse().toString();
    }
}
