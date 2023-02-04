package lesson9_arraylist_linkedlist.my_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(13);
        ll.addFirst(12);

        ll.add(2,9);
        ll.add(1,20);
        ll.addLast(14);
        System.out.println("Size: " + ll.size());
        System.out.println("List: ");
        ll.printList();
        System.out.println(ll.contains(30));
        System.out.println(ll.contains(9));
        System.out.println(ll.indexOf(2));
        System.out.println(ll.indexOf(14));
//        ll.remove(2);
//        System.out.println("Size: " + ll.size());
//        System.out.println("List: ");
//        ll.printList();

        System.out.println("Head: " + ll.getFirst());
        System.out.println("Tail: " + ll.getLast());
    }
}
