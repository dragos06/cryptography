package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private List<String> words;

    public FileProcessor() {
        this.words = new ArrayList<>();
        readFile();
    }

    private void readFile() {
        try {
            FileReader fileReader = new FileReader("resources/wordlist.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                words.add(line.toUpperCase());
            }

            fileReader.close();
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWords() {
        return words;
    }
}
