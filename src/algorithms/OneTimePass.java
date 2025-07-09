package algorithms;

import utils.Constants;

public class OneTimePass {
    public String encrypt(String plainText, int[] key) {
        plainText = plainText.toUpperCase();
        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++) {
            char plainLetter = plainText.charAt(i);
            int plainIndex = Constants.ALPHABET.indexOf(plainLetter);

            int keyIndex = key[i];

            int cipherIndex = Math.floorMod(plainIndex + keyIndex, Constants.ALPHABET.length());
            char cipherLetter = Constants.ALPHABET.charAt(cipherIndex);

            cipherText += cipherLetter;
        }

        return cipherText;
    }

    public String decrypt(String cipherText, int[] key) {
        cipherText = cipherText.toUpperCase();
        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {
            char cipherLetter = cipherText.charAt(i);
            int cipherIndex = Constants.ALPHABET.indexOf(cipherLetter);

            int keyIndex = key[i];

            int plainIndex = Math.floorMod(cipherIndex - keyIndex, Constants.ALPHABET.length());
            char plainLetter = Constants.ALPHABET.charAt(plainIndex);

            plainText += plainLetter;
        }

        return plainText;
    }
}
