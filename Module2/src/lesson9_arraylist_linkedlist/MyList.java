package lesson9_arraylist_linkedlist;

import java.util.ArrayList;

public class MyList<E> {
    ArrayList<E> myList = new ArrayList<E>();

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public MyList() {
    }

    public MyList(int capacity) {
        this.capacity = capacity;
    }

    void add(int index, E element)
    {
        
    }
}
