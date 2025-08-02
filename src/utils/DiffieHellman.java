package utils;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {
    private Random random;

    public DiffieHellman() {
        this.random = new Random();
    }

    public void generatePrivateKeys(BigInteger n, BigInteger g) {
        BigInteger x = new BigInteger(Integer.toString(this.random.nextInt(n.intValue() - 2) + 1));
        BigInteger y = new BigInteger(Integer.toString(this.random.nextInt(n.intValue() - 2) + 1));

        BigInteger k1 = g.modPow(x, n);
        BigInteger k2 = g.modPow(y, n);

        BigInteger key1 = k2.modPow(x, n);
        BigInteger key2 = k1.modPow(y, n);

        System.out.format("A: %d, B: %d", key1, key2);
    }
}
