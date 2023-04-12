package lesson9_arraylist_linkedlist.my_arrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void ensureCapa() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public void add(E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = element;
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        E e = (E) elements[index];
        if (index < 0 || index > size) {
            return null;
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public E clone() {
        return null;
    }

    public boolean contains(E o) {
        for (int i = 0; i < elements.length; i++) {
            if(elements[i].equals(o))
            {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if(elements[i].equals(o))
            {
                return i;
            }
        }
        return -1;
    }

//    public boolean add(E o) {
//        return true;
//    }

    public E get(int i) {
        if (i < 0 || i > size) {
            return null;
        }
        return (E) elements[i];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
