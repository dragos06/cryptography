package utils;

public class GreatestCommonDivisor {
    public int gcdRecursive(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcdRecursive(b, a % b);
    }

    public int gcdIterative(int a, int b) {
        int temp = 0;

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
