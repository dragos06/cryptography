import algorithms.CaesarCipher;
import cracks.CaesarCipherBruteForce;
import utils.FrequencyAnalysis;

public class App {
    public static void main(String[] args) throws Exception {
        CaesarCipher cc = new CaesarCipher(3);

        String plainText = "This is a longer sentence in order to check the frequencies";
        String cipherText = cc.encrypt(plainText);
        String newPlainText = cc.decrypt(cipherText);
        System.out.println(cipherText);
        System.out.println(newPlainText);

        CaesarCipherBruteForce ccbf = new CaesarCipherBruteForce(cc.getAlphabet());
        ccbf.crack(cipherText);

        FrequencyAnalysis fa = new FrequencyAnalysis();
        fa.showFrequencies(plainText);
    }
}
