import java.util.*;

public class Sort {
    public static int count =0, lenght;
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Länge der Liste: ");
        lenght = reader.nextInt();
        int[] orderedArray = new int[Sort.lenght];
        int[] reversedArray = new int[Sort.lenght];
        int[] randomArray = new int[Sort.lenght];
        createList(orderedArray, reversedArray, randomArray, lenght);

        Map<String, int[]> list = new HashMap();

        list.put("geordnet", orderedArray);
        list.put("verkehrt geordnet", reversedArray);
        list.put("ungeordnet", randomArray);
        
        System.out.println("Insertionsort: ");
        for(int[] i : list.values()){
            long start = System.nanoTime();
            binaryInsertionSort(i);
            long end = System.nanoTime();
            System.out.println("Das Sortieren der Liste: " + getKey(list, i) + " hat "+ (end-start) + " Nanosekunden gedauert");
        }
        createList(orderedArray, reversedArray, randomArray, lenght);

        for(int i : reversedArray){
            System.out.println(i);
        }

        System.out.println("Bubblesort: ");
        for(int[] i : list.values()){
            long start = System.nanoTime();
            bubbleSort(i);
            long end = System.nanoTime();
            System.out.println("Das Sortieren der Liste: " + getKey(list, i) + " hat "+ (end-start) + " Nanosekunden gedauert");
        }
    }
    static void bubbleSort(int[] list) {
       int temp = 0;
        for(int i=0; i < list.length; i++){
            for(int j=1; j < (list.length-i); j++){
                if(list[j-1] > list[j]){
                    temp = list[j-1];
                    list[j-1] =  list[j];
                    list[j] =  temp;
                    count++;
                }
            }
        }
    }
    static void createList(int[] orderedArray, int[] reversedArray, int[] randomArray, int lenght){
        Random rnd = new Random(Sort.lenght);
        int[] tempArray = new int[lenght];


        for(int i = 0; i < randomArray.length; i++) {
            orderedArray[i] = i;
            tempArray[i] = i;
        }

        int temp, temp2;
        for(int i = 0; i < randomArray.length; i++) {
            temp2 = rnd.nextInt(tempArray.length-i);
            randomArray[i] = tempArray[temp2];
            temp = tempArray[tempArray.length-i-1];
            tempArray[tempArray.length-i-1] = tempArray[temp2];
            tempArray[temp2] = temp;
        }
        int count=0;
        for(int i = reversedArray.length-1; i >= 0 ; i--) {
            reversedArray[count] = i;
            count++;
        }
    }
    public static void binaryInsertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; ++i) {
            int key = array[i];
            int insertedPosition = findPosition(array, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                array[j + 1] = array[j];
            }

            array[insertedPosition] = key;
        }
    }

    public static int findPosition(int[] array, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    //methode aus dem Internet
    public static <K, V> K getKey(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

}
