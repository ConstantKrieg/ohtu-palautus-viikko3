import java.util.*;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
        final int testiluku = 3;
        Scanner scanner = new Scanner(System.in);
        Multiplier kolme = new Multiplier(testiluku);
        System.out.println("anna luku ");
        int luku = scanner.nextInt();

        System.out.println("luku kertaa kolme on "+kolme.multipliedBy(luku) );
    }
}
