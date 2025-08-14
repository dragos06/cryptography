package algorithms;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger publicKey;
    private BigInteger privateKey;
    private BigInteger n;
    private SecureRandom secureRandom;

    public RSA() {
        this.secureRandom = new SecureRandom();
    }

    public void generateKeys(int keyDigits) {
        BigInteger p = BigInteger.probablePrime(keyDigits, this.secureRandom);
        BigInteger q = BigInteger.probablePrime(keyDigits, secureRandom);

        this.n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = generatePublicFactor(phi);
        BigInteger d = e.modInverse(phi);

        this.publicKey = e;
        this.privateKey = d;
    }

    private BigInteger generatePublicFactor(BigInteger phi) {
        BigInteger e = new BigInteger(phi.bitLength(), this.secureRandom);

        while (!e.gcd(phi).equals(BigInteger.ONE)) {
            e = new BigInteger(phi.bitLength(), this.secureRandom);
        }

        return e;
    }

    public BigInteger encryptMessage(String message) {
        return this.encrypt(this.publicKey, this.n, message);
    }

    private BigInteger encrypt(BigInteger e, BigInteger n, String message) {
        BigInteger messageBigInteger = new BigInteger(message.getBytes());

        return messageBigInteger.modPow(e, n);
    }

    public String decryptMessage(BigInteger message) {
        return this.decrypt(this.privateKey, this.n, message);
    }

    private String decrypt(BigInteger d, BigInteger n, BigInteger message) {
        BigInteger messageBigInteger = message.modPow(d, n);

        return new String(messageBigInteger.toByteArray());
    }
}
