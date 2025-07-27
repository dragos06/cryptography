package utils;

import java.math.BigInteger;
import java.util.Random;

public class FermatPrimeTest {
    private Random random;

    public FermatPrimeTest() {
        this.random = new Random();
    }

    public boolean isPrime(BigInteger n, int k) {
        if (n.intValue() < 2) {
            return false;
        }

        if (n.intValue() == 2) {
            return true;
        }

        if (n.intValue() % 2 == 0) {
            return false;
        }

        for (int i = 0; i < k; i++) {
            // random number [2, n-1]
            BigInteger a = BigInteger.valueOf(this.random.nextInt(n.intValue() - 2) + 2);

            // n prime <=> a^(n-1) % n == 1
            if (!a.modPow(n.subtract(BigInteger.ONE), n).equals(BigInteger.ONE)) {
                return false;
            }
        }

        return true;
    }
}
