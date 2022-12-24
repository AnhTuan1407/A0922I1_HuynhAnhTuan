package lesson_5_access_modifier;

public class Student {
    private String name;
    private String classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Student() {
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Tuan");
        student.setClasses("A0922I1");
        System.out.println("Name: " + student.getName() + ", Class: " + student.getClasses());
    }
}
