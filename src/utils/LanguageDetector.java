package utils;

import java.util.List;

public class LanguageDetector {
    private FileProcessor fileProcessor;
    private List<String> englishWords;

    public LanguageDetector() {
        this.fileProcessor = new FileProcessor();
        this.englishWords = fileProcessor.getWords();
    }

    private int numberEnglishWords(String text) {
        int matches = 0;

        String[] words = text.toUpperCase().split(" ");
        for (String word : words) {
            if (this.englishWords.contains(word)) {
                matches++;
            }
        }

        return matches;
    }

    public boolean isEnglish(String text) {
        int matches = this.numberEnglishWords(text);

        return (float) matches / text.toUpperCase().split(" ").length * 100 >= 70;
    }
}
