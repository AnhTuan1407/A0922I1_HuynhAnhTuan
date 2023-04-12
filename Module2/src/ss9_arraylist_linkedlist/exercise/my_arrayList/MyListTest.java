package lesson9_arraylist_linkedlist.my_arrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();

        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

//        System.out.println("Size: " + listInteger.size());
//        System.out.println(listInteger.contains(0));
//        System.out.println(listInteger.contains(1));
//        System.out.println(listInteger.indexOf(2));
//        System.out.println(listInteger.indexOf(0));
//        System.out.println("Element 2: " + listInteger.get(2));
//        listInteger.clear();
//        System.out.println("Size: " + listInteger.size());

        listInteger.add(1, 0);
        listInteger.remove(1);
        System.out.println(listInteger.indexOf(5));
    }
}
