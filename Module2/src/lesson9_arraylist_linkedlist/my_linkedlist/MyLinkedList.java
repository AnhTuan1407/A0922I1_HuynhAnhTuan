package lesson9_arraylist_linkedlist.my_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList(E data) {
        head = new Node(data);
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    public void add(int index, E data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && head != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public E remove(int index) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next.next;
        temp.next = holder;
        numNodes--;
        return null;
    }

    public int size() {
        return numNodes + 1;
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < this.numNodes; i++) {
            if (temp.data == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i <= this.numNodes; i++) {
            if (temp.data.equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        for (int i = 0; i < this.numNodes; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {

    }
}
