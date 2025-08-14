package utils;

public class ModularInverse {
    public int calculate(int a, int m) {
        for (int i = 0; i < m; i++) {
            if ((a * i) % m == 1) {
                return i;
            }
        }

        return -1;
    }
}
