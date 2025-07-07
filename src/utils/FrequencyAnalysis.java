package utils;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {
    private String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public FrequencyAnalysis() {
    }

    public FrequencyAnalysis(String alphabet) {
        this.alphabet = alphabet;
    }

    public Map<Character, Integer> run(String text) {
        text = text.toUpperCase();

        Map<Character, Integer> frequencies = new HashMap<Character, Integer>();

        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if (this.alphabet.indexOf(character) != -1) {
                if (frequencies.get(character) != null) {
                    frequencies.put(character, frequencies.get(character) + 1);
                } else {
                    frequencies.put(character, 1);
                }
            }
        }

        return frequencies;
    }

    public void showFrequencies(String text) {
        Map<Character, Integer> frequencies = run(text);
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            System.out.format("%s : %d%n", entry.getKey(), entry.getValue());
        }
    }
}
