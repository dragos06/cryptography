package cracks;

import java.util.Map;

import utils.FrequencyAnalysis;

public class CaesarCipherFrequencyAnalysis {
    private String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private FrequencyAnalysis frequencyAnalysis;

    public CaesarCipherFrequencyAnalysis() {
        this.frequencyAnalysis = new FrequencyAnalysis();
    }

    public CaesarCipherFrequencyAnalysis(String alphabet) {
        this.alphabet = alphabet;
        this.frequencyAnalysis = new FrequencyAnalysis();
    }

    public void crack(String cipherText) {
        Map<Character, Integer> letterFrequencies = frequencyAnalysis.run(cipherText);
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : letterFrequencies.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        char mostFrequenctChar = maxEntry.getKey();
        int approximatedKey = this.alphabet.indexOf(mostFrequenctChar) - this.alphabet.indexOf(' ');

        System.out.println("The approximated key is: " + approximatedKey);
    }
}
