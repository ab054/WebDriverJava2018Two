package day4;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CodeEx3 {

    List list;

    @Test
    public void testList() {
        list = new ArrayList();

        list.add(0, 12);
        list.add(1, 13);
        list.add(2, 14);
        list.add(3, 15);
        list.add(4, 16);
        list.add(5, 17);

        execOperation(0, 2, "Insert");
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
