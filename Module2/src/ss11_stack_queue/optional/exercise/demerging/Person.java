package lesson11_stack_queue.optional.exercise.demerging;

import java.time.LocalDate;

public class Person implements Comparable<Person>{
    public String namePerson;
    public String gender;
    public LocalDate dayOfBirth;

    public Person(String namePerson, String gender, LocalDate dayOfBirth) {
        this.namePerson = namePerson;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "namePerson='" + namePerson + '\'' +
                ", gender='" + gender + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}' + "\n";
    }

    @Override
    public int compareTo(Person o) {
        return this.dayOfBirth.compareTo(o.dayOfBirth);
    }
}
