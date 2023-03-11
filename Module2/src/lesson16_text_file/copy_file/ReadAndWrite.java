package lesson16_text_file.copy_file;

import lesson16_text_file.read_file.ReadFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ReadAndWrite {
    public static void main(String[] args) {
        File file = new File("src/lesson16_text_file/copy_file/genshin");
        try {
            PrintWriter printWriter = new PrintWriter("src/lesson16_text_file/copy_file/Result");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                printWriter.println(line);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





