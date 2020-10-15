import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Anzahl von Fibonacci Zahlen: ");
        System.out.println(fibonacci(reader.nextInt()));


    }
    public static int fibonacci(int anzahl){
        if(anzahl <=1){
            return anzahl;
        }
        return fibonacci(anzahl -1) + fibonacci(anzahl -2);
    }
}
