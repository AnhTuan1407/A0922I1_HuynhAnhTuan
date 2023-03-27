package linked_list;

import java.util.Random;

public class MyLinkedList {
    Node head = null;
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            Node next = null;
        }

        Node(int data, Node t)
        {
            this.data = data;
            Node next = t;
        }
    }

    public void nhap(int data) {
        Node x = new Node(data);
        if (head == null)
        {
            head = x;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = x;
        }
    }

    public void in() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.nhap(1);
        l.nhap(2);
        l.nhap(3);
        l.nhap(4);
        l.nhap(5);
        l.in();
    }
}
