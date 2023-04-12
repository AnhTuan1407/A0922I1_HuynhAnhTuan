package lesson11_stack_queue.optional.exercise.demerging;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        Queue<Person> femaleQueue = new LinkedList<>();
        Queue<Person> maleQueue = new LinkedList<>();

        personList.add(new Person("Tuan", "male", LocalDate.parse("2003-07-14")));
        personList.add(new Person("Tan", "male", LocalDate.parse("1991-01-22")));
        personList.add(new Person("Ngoc", "female", LocalDate.parse("1996-03-20")));
        personList.add(new Person("Thu", "female", LocalDate.parse("2003-07-29")));
        personList.add(new Person("Thang", "male", LocalDate.parse("1999-07-21")));
        Collections.sort(personList);
        System.out.println(personList.toString());

        for (Person p : personList) {
            if (p.gender == "female") {
                femaleQueue.offer(p);
            } else {
                maleQueue.offer(p);
            }
        }

        System.out.println("DISPLAY");
        while (!femaleQueue.isEmpty()) {
            System.out.println(femaleQueue.remove());
        }
        while (!maleQueue.isEmpty()) {
            System.out.println(maleQueue.remove());
        }
    }
}
