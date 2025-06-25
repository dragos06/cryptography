package cracks;

public class CaesarCipherBruteForce {
    private String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CaesarCipherBruteForce() {

    }

    public CaesarCipherBruteForce(String alphabet) {
        this.alphabet = alphabet;
    }

    public void crack(String cipherText) {
        for (int key = 1; key < this.alphabet.length(); key++) {
            String plainText = "";

            cipherText = cipherText.toUpperCase();

            for (int i = 0; i < cipherText.length(); i++) {
                char cipherLetter = cipherText.charAt(i);

                int cipherIndex = this.alphabet.indexOf(cipherLetter);

                int plainIndex = Math.floorMod(cipherIndex - key, this.alphabet.length());

                char plainLetter = this.alphabet.charAt(plainIndex);

                plainText += plainLetter;
            }

            System.out.println(String.format("Key %d: %s", key, plainText));
        }
    }
}
