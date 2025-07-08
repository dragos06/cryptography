import algorithms.CaesarCipher;
import algorithms.VigenereCipher;
import cracks.CaesarCipherBruteForce;
import cracks.CaesarCipherFrequencyAnalysis;

public class App {
    public static void main(String[] args) throws Exception {
        // caesarCipher();
        vigenereCipher();
    }

    private static void caesarCipher() {
        CaesarCipher cc = new CaesarCipher(3);

        String plainText = "This is a longer sentence in order to check the frequencies to crack the cipher";
        String cipherText = cc.encrypt(plainText);
        String newPlainText = cc.decrypt(cipherText);
        System.out.println(cipherText);
        System.out.println(newPlainText);

        CaesarCipherBruteForce ccbf = new CaesarCipherBruteForce(cc.getAlphabet());
        ccbf.crack(cipherText);

        CaesarCipherFrequencyAnalysis ccfa = new CaesarCipherFrequencyAnalysis();
        ccfa.crack(cipherText);
    }

    private static void vigenereCipher() {
        VigenereCipher vg = new VigenereCipher();

        String plainText = "This is a sentence meant to be used in order to check if the Vigenere object encrypts and decrypts strings correctly";
        String key = "FOOBAR";
        String cipherText = vg.encrypt(plainText, key);
        String newPlainText = vg.decrypt(cipherText, key);
        System.out.println(cipherText);
        System.out.println(newPlainText);
    }
}
