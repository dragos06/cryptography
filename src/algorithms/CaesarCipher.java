package algorithms;

public class CaesarCipher {
    private String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int key = 1;

    public CaesarCipher() {
    }

    public CaesarCipher(int key) {
        this.key = key;
    }

    public CaesarCipher(String alphabet, int key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String encrypt(String plainText) {
        String cipherText = "";

        plainText = plainText.toUpperCase();

        for (int i = 0; i < plainText.length(); i++) {
            char plainLetter = plainText.charAt(i);

            int plainIndex = this.alphabet.indexOf(plainLetter);

            int cipherIndex = Math.floorMod(plainIndex + this.key, this.alphabet.length());

            char cipherLetter = this.alphabet.charAt(cipherIndex);

            cipherText += cipherLetter;
        }

        return cipherText;
    }

    public String decrypt(String cipherText) {
        String plainText = "";

        cipherText = cipherText.toUpperCase();

        for (int i = 0; i < cipherText.length(); i++) {
            char cipherLetter = cipherText.charAt(i);

            int cipherIndex = this.alphabet.indexOf(cipherLetter);

            int plainIndex = Math.floorMod(cipherIndex - this.key, this.alphabet.length());

            char plainLetter = this.alphabet.charAt(plainIndex);

            plainText += plainLetter;
        }

        return plainText;
    }
}
