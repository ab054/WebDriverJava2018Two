package day5;

import org.testng.annotations.Test;

import java.util.Arrays;

public class CodingQuestions {

    @Test
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 15; i++) {
            if (i%2==1) System.out.println(i);
        }
    }

    @Test
    public void printHelloAtEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i%2==0) System.out.println("hello world");
        }
    }

    @Test
    public void swapTwoNumbersInArray() {
        int[] array = {1,2,3,4,5,6};

        swap(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
    private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
    }

    @Test
    public void testCountLetters() {
        String input = "hello world";
        int result = 0;

        char[] charArray = input.toCharArray();

        for(char eachChar : charArray){
            if(eachChar== 'l') result++;
        }
        System.out.println("The result is " + result);
    }

    @Test
    public void testConstructor() {
        MyClass myClass = new MyClass();
    }
}
