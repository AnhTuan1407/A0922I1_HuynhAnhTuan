package lesson11_stack_queue.exercise;

import java.util.TreeMap;

public class MapCountWords {
    public static void main(String[] args) {
        String str = "Lech Keqing pity 80 Yelan cua tao dau Michos";
        String[] arrStr = str.split(" ");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arrStr.length; i++) {
            if (treeMap.containsKey(arrStr[i])) {
                int value = treeMap.get(arrStr[i]) + 1;
                treeMap.put(arrStr[i], value);
            } else {
                treeMap.put(arrStr[i], 1);
            }
        }
        System.out.println(treeMap);
    }
}
