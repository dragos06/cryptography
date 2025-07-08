import algorithms.CaesarCipher;
import cracks.CaesarCipherBruteForce;
import cracks.CaesarCipherFrequencyAnalysis;

public class App {
    public static void main(String[] args) throws Exception {
        caesarCipher();
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
}
