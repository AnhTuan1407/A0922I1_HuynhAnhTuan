package lesson16_text_file.read_file;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFile file = new ReadFile();
        List<Country> countries = file.readToFile();
        countries.forEach(System.out::println);
        file.writeToFile("src/lesson16_text_file/read_file/result", countries);
    }
}
