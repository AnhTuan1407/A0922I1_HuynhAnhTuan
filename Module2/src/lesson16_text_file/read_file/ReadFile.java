package lesson16_text_file.read_file;

import lesson16_text_file.demo.filecharacter.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static final String BLANK = "";
    public static final String DEMILITER = ",";

    public List<Country> readToFile() {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/lesson16_text_file/read_file/country"))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] result = line.trim().split(DEMILITER);
                Country country = new Country(result);
                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public void writeToFile(String path, List<Country> countries) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (Country c : countries) {
                bufferedWriter.write(c.toString());
                bufferedWriter.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
