package day6;

import org.testng.annotations.Test;

public class ForLoops {

    @Test
    public void testLabeledForLoops() {

        aa: for (int i = 1; i <= 3; i++) {
            if (i == 1)
                continue;
            bb: for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break aa;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
