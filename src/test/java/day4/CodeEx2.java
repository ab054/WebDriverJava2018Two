package day4;

import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class CodeEx2 {

    @Test
    public void testSubstringComparisons() throws Exception {
        String inputString = "welcometojava";
        int inputInt = 4;

        System.out.println(getSmallestAndLargest(inputString, inputInt));
    }

    private String getSmallestAndLargest(String inputString, int inputInt) {
        String smallest = "";
        String largest = "";

        SortedSet<String> sets = new TreeSet<String>();

        for(int i = 0; i <= inputString.length() - inputInt; i++){
            String subString = inputString.substring(i, i + inputInt);
            sets.add(subString);
        }

        return sets.first() + "\n" + sets.last();
    }
}
