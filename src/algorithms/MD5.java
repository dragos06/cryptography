package algorithms;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public String digest(String message) {
        MessageDigest messageDigest = null;
        byte[] messageDigestByteArray = null;
        String hexaHash = "";

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigestByteArray = messageDigest.digest(message.getBytes());
            hexaHash = new BigInteger(1, messageDigestByteArray).toString(16);
            while (hexaHash.length() < 32) {
                hexaHash = "0" + hexaHash;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hexaHash;
    }
}
