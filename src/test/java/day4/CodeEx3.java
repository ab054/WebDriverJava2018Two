package day4;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CodeEx3 {

    List list;

    @Test
    public void test1DArray() {
        list = new ArrayList();

        list.add(0, 11);
        list.add(1, 12);
        list.add(2, 13);
        list.add(3, 14);
        list.add(4, 15);
        list.add(5, 16);

        printList();

        execOperation(1, 2, "Insert");

        printList();

        execOperation(1, 2, "Delete");

        printList();
    }

    private void printList() {
        for(Object each : list.toArray()){
            System.out.print(each + " ");
        }

        System.out.println("");
    }

    private void execOperation(Object object, int index, String operation) {
        if(operation.contains("Insert")){
            list.add(index, object);
        }
        if(operation.contains("Delete")){
            list.remove(object);
        }
    }
}
