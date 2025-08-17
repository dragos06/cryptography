import java.math.BigInteger;
import java.util.Random;

import algorithms.AdvancedEncryptionStandard;
import algorithms.CaesarCipher;
import algorithms.DataEncryptionStandard;
import algorithms.EllipticCurveCryptography;
import algorithms.MD5;
import algorithms.OneTimePass;
import algorithms.RSA;
import algorithms.SHA256;
import algorithms.VigenereCipher;
import cracks.CaesarCipherBruteForce;
import cracks.CaesarCipherFrequencyAnalysis;
import utils.Point;
import utils.RandomGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        caesarCipher();
        vigenereCipher();
        oneTimePass();
        dataEncryptionStandard();
        advancedEncryptionStandard();
        rsa();
        ecc();
        md5();
        sha256();
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

    private static void dataEncryptionStandard() {
        DataEncryptionStandard das = new DataEncryptionStandard();
        String plainText = "This is just an example in order to check if the encryption and decryption of the algorithm works";
        String cipherText = das.encrypt(plainText);
        String newPlainText = das.decrypt(cipherText);
        System.out.println(cipherText);
        System.out.println(newPlainText);
    }

    private static void advancedEncryptionStandard() {
        AdvancedEncryptionStandard aes = new AdvancedEncryptionStandard();
        String plainText = "This is just an example in order to check if the encryption and decryption of the algorithm works";
        String cipherText = aes.encrypt(plainText);
        String newPlainText = aes.decrypt(cipherText);
        System.out.println(cipherText);
        System.out.println(newPlainText);
    }

    private static void rsa() {
        RSA rsa = new RSA();
        String plainText = "This is just an example in order to check if the encryption and decryption of the algorithm works";
        rsa.generateKeys(1024);
        BigInteger cipherText = rsa.encryptMessage(plainText);
        String newPlainText = rsa.decryptMessage(cipherText);
        System.out.println(cipherText);
        System.out.println(newPlainText);
    }

    private static void ecc() {
        EllipticCurveCryptography ecc = new EllipticCurveCryptography(3, 7);
        Point generator = new Point(-2, 1);

        Random random = new Random();

        int a = random.nextInt(10000);
        int b = random.nextInt(10000);

        Point aPublicKey = ecc.doubleAndAdd(a, generator);
        Point bPublicKey = ecc.doubleAndAdd(b, generator);

        Point aPrivateKey = ecc.doubleAndAdd(a, bPublicKey);
        Point bPrivateKey = ecc.doubleAndAdd(b, aPublicKey);

        System.out.println(aPrivateKey);
        System.out.println(bPrivateKey);
    }

    private static void md5() {
        MD5 md5 = new MD5();
        String message = "This is an example to check if the hashing alg works";
        System.out.println(md5.digest(message));
    }

    private static void sha256() {
        SHA256 sha256 = new SHA256();
        String message = "This is an example to check if the hashing alg works";
        System.out.println(sha256.digest(message));
    }
}
