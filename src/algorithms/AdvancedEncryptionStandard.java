package algorithms;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AdvancedEncryptionStandard {
    private SecretKey secretKey;
    private SecureRandom secureRandom;
    private Cipher encryptCipher;
    private Cipher decryptCipher;
    private IvParameterSpec ivParameterSpec;

    public AdvancedEncryptionStandard() {
        try {
            this.secretKey = KeyGenerator.getInstance("AES").generateKey();
            this.secureRandom = new SecureRandom();
            this.encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] initializationVector = new byte[this.encryptCipher.getBlockSize()];
            this.secureRandom.nextBytes(initializationVector);
            this.ivParameterSpec = new IvParameterSpec(initializationVector);
            this.encryptCipher.init(Cipher.ENCRYPT_MODE, this.secretKey, this.ivParameterSpec);
            this.decryptCipher.init(Cipher.DECRYPT_MODE, this.secretKey, this.ivParameterSpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String plainText) {
        byte[] bytes = plainText.getBytes();
        byte[] cipherText = null;

        try {
            cipherText = this.encryptCipher.doFinal(bytes);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(cipherText);
    }

    public String decrypt(String cipherText) {
        byte[] bytes = Base64.getDecoder().decode(cipherText.getBytes());
        byte[] plainText = null;

        try {
            plainText = this.decryptCipher.doFinal(bytes);

            return new String(plainText, "UTF8");
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
