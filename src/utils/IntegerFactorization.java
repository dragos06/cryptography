package utils;

public class IntegerFactorization {
    public void factor(int n){
        for(int i = 2; i < Math.floor(Math.sqrt(n)); i++){
            if(n % i == 0){
                System.out.format("Factors: [%d, %d]\n", i, n / i);
            }
        }
    }
}
