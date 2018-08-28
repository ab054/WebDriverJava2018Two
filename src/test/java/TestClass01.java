import org.testng.annotations.Test;

public class TestClass01 {

    @Test
    public void test001(){
        System.out.println("Hello, World!");
    }

    @Test
    public void test002() {
        int myNumber;
        myNumber = 5;

        System.out.println(myNumber);
    }

    @Test
    public void test003() {

        String s1 = new String("Who let the dogs out?");

        String s2 = "Who who who who!";

        String s3 = s1 + s2;

        System.out.println(s3);
    }

    @Test
    public void test004() {
        int num = 6;
        String s = "I have " + num + " cookies";

        System.out.println(s);
    }

    @Test
    public void test005() {
        boolean b;
        b = true;

        boolean toBe = false;
        b = toBe || !toBe;

        if (toBe) {
            System.out.println("b is true");
        }
    }

    @Test
    public void test006() {
        int a = 1;
        int b = 2;

        if (a == b)
            System.out.println("Another line Wow!");
        else
            System.out.println("Double rainbow!");
    }

    @Test
    public void test007() {
        int[] arr = {1, 2, 3, 4, 5};
        int currentEL = 0;

        for(int i = 0; i < arr.length; i ++){
            currentEL = arr[i];
        }

        System.out.println(currentEL);
    }

    @Test
    public void test008() {
        String[] arr = {"String1", "String2", "String3", "String4", "String5"};

        printValuesOfTheArray(arr);
    }

    public void printValuesOfTheArray(String[] arr) {
        for (String el : arr) {
            System.out.println(el);
        }
    }
}
