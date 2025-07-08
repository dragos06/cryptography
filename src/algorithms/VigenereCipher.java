package algorithms;

public class VigenereCipher {
    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String plainText, String key) {
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();
        String cipherText = "";

        int currentKeyIndex = 0;

        for (int i = 0; i < plainText.length(); i++) {
            char plainLetter = plainText.charAt(i);
            int plainIndex = ALPHABET.indexOf(plainLetter);

            char keyLetter = key.charAt(currentKeyIndex);
            int keyIndex = ALPHABET.indexOf(keyLetter);

            int cipherIndex = Math.floorMod(plainIndex + keyIndex, ALPHABET.length());
            char cipherLetter = ALPHABET.charAt(cipherIndex);

            cipherText += cipherLetter;
            currentKeyIndex = (currentKeyIndex + 1) % key.length();
        }

        return cipherText;
    }

    public String decrypt(String cipherText, String key) {
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();
        String plainText = "";

        int currentKeyIndex = 0;

        for (int i = 0; i < cipherText.length(); i++) {
            char cipherLetter = cipherText.charAt(i);
            int cipherIndex = ALPHABET.indexOf(cipherLetter);

            char keyLetter = key.charAt(currentKeyIndex);
            int keyIndex = ALPHABET.indexOf(keyLetter);

            int plainIndex = Math.floorMod(cipherIndex - keyIndex, ALPHABET.length());
            char plainLetter = ALPHABET.charAt(plainIndex);

            plainText += plainLetter;
            currentKeyIndex = (currentKeyIndex + 1) % key.length();
        }

        return plainText;
    }
}
