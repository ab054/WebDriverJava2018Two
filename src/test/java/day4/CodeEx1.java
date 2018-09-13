package day4;

import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class CodeEx1 {

    @Test
    public void testSubstringComparisons() {
        String input = "welcometojava";
        int size = 3;

        SortedSet<String> sets = new TreeSet<String>();

        for(int i = 0; i <= input.length()- size; i++){
            int beginIndex = i;
            int endIndex = i + size;
            String substring = input.substring(beginIndex, endIndex);
            sets.add(substring);
        }

        System.out.println(sets.first());
        System.out.println(sets.last());
    }
}
