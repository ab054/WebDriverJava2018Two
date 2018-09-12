package day4;

import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class CodeEx2 {


    @Test
    public void testSubstrings() {

        String input = "welcomeJava"; // wel, elc, lco, com, ....
        int size = 3;

        String smallest = "";
        String largest = "";

        //data structure which will allow to store substrings in ordered way
        SortedSet<String> sets = new TreeSet<String>();

        for(int i = 0; i <= input.length() - size; i++){
            String subString = input.substring(i, i + size); // (0,3), (1,4), (2,5)...
            sets.add(subString);
        }

        System.out.println(sets.first() + "\n   " + sets.last());


    }
}
