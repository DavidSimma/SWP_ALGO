import java.util.Scanner;

public class Potenzrechnung {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Basis: ");
        int basis = reader.nextInt();
        System.out.print("Potenz: ");
        int potenz = reader.nextInt();
        System.out.println(Regression(basis, potenz));
    }
    public static int Regression(int base, int potenz){
        if(potenz == 0){
            return 1;
        }
        return Regression(base, potenz-1) * base;
    }
}
