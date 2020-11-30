public class Fibonacci_Endrekursion {
    public static void main(String[] args) {
        System.out.println(fib1(20));
    }
    public static int fib1(int n){
        return fib2(n-1, 1, 0);
    }
    public static int fib2(int n, int einz, int zwei){
        if (n<=1) return einz+zwei;
        return fib2(n-1, einz+zwei, einz);
    }
}
