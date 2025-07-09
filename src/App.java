import algorithms.CaesarCipher;
import algorithms.OneTimePass;
import algorithms.VigenereCipher;
import cracks.CaesarCipherBruteForce;
import cracks.CaesarCipherFrequencyAnalysis;
import utils.RandomGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        // caesarCipher();
        // vigenereCipher();
        oneTimePass();
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

    private static void oneTimePass() {
        String plainText = "This is just an example in order to check if the encryption and decryption of the algorithm works";
        RandomGenerator randomGenerator = new RandomGenerator();
        int[] randomKey = randomGenerator.generate(plainText.length());
        OneTimePass otp = new OneTimePass();
        String cipherText = otp.encrypt(plainText, randomKey);
        String newPlainText = otp.decrypt(cipherText, randomKey);
        System.out.println(cipherText);
        System.out.println(newPlainText);
    }
}
