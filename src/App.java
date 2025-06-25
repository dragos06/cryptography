import algorithms.CaesarCipher;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CaesarCipher cc = new CaesarCipher(3);

        String plainText = "This is an example";
        String cipherText = cc.encrypt(plainText);
        String newPlainText = cc.decrypt(cipherText);
        System.out.println(cipherText);
        System.out.println(newPlainText);
    }
}
