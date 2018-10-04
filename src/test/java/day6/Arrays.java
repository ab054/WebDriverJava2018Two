package day6;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Arrays {

    @Test
    public void testArrays() {
        int[] ints = {1,2,3,4,5,6,7};

        for(int each : ints){
            System.out.println(each);
        }
    }

    @Test
    public void ArrayList() {
        ArrayList<Integer> ints = new ArrayList<Integer>();

        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);

        for(int each : ints){
            System.out.println(each);
        }
    }
}
