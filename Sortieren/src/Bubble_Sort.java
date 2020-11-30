import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bubble_Sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        System.out.print("Länge der Liste: ");
        createList(list, reader.nextInt());

        System.out.println("Liste (ungeordnet): ");
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        long start = System.nanoTime();
        bubbleSort(list);
        long end = System.nanoTime();
        System.out.println("\nListe (geordnet): ");
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)  + " ");
        }
        System.out.println("\nDas Sortieren der Liste hat "+ (end-start) + " Nanosekunden gedauert");
    }
    static void bubbleSort(List<Integer> list) {
       int temp = 0;
        for(int i=0; i < list.size(); i++){
            for(int j=1; j < (list.size()-i); j++){
                if(list.get(j-1) > list.get(j)){
                    temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
    static void createList(List<Integer> list, int lenght){
        Random rnd = new Random();
        for (int i = 0; i < lenght; i++){
            list.add(rnd.nextInt(5000));
        }
    }
}
