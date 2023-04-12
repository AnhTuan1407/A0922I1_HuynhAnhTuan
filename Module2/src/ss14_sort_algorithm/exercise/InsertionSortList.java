package lesson14_sort_algorithm;

public class InsertionSortList {
    public static void insertionSort(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;

            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
    }

    public static void main(String[] args) {
        int[] arrInt = new int[10];
        for (int i = 0; i < arrInt.length; i++) {
            int code = (int) Math.floor(((Math.random() * 99) + 10));
            arrInt[i] = code;
        }
        for (int c : arrInt) {
            System.out.print(c + " ");
        }

        System.out.println("\nSORT");

        insertionSort(arrInt);

        for (int c : arrInt) {
            System.out.print(c + " ");
        }
    }
}
