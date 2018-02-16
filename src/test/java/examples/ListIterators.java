package examples;

import java.util.*;

public class ListIterators {
    public List<String> myList1;
    public List<String> myList2;

    public ListIterators () {
        createList1();
        createList2();
    }

    public void createList1 () {
        myList1 = new ArrayList<String>();
        myList1.add("A");
        myList1.add("B");
        myList1.add("C");
    }

    public void createList2 () {
        myList2 = Arrays.asList("zero", "one", "two");
    }

    public void printList1() {
        for (String item : myList1) {
            System.out.println(item);
        }
    }

    public void printList2() {
        for(Iterator<String> i = myList1.iterator(); i.hasNext(); ) {
            String item = i.next();
            System.out.println(item);
        }
    }

    // this code will not work for List (only for Array)
    public void printList3() {
        for (int i = 0; i < myList1.size(); i++) {
            //String item = myList[i];
            //System.out.println(item);
        }
    }

    public void printList4() {
        ListIterator iterator = myList1.listIterator();
        while (iterator.hasNext()) {
            System.out.println("index: " + iterator.nextIndex() + " value: " + iterator.next());
        }
    }

    public void printList5() {
        int i = 0;
        for (Iterator<String> it = myList1.iterator(); it.hasNext(); i++) {
            String s = it.next();
            System.out.println(i + ": " + s);
        }
    }

}
