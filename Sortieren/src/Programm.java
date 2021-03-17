import java.util.*;

public class Programm {
    public static int lenght;
    public static Scanner reader = new Scanner(System.in);
    public static List<List<Integer>> sourceList = new ArrayList<>();
    public static List<List<Integer>> allLists = new ArrayList<>();
    public static List<List<Integer>> allLists2 = new ArrayList<>();
    public static List<List<Integer>> allLists3 = new ArrayList<>();
    public static List<List<Integer>> allLists4 = new ArrayList<>();

    public static void main(String[] args) {

        schrittVergleich();


    }

    public static void zeitVergleich(){
        System.out.print("Länge der Liste: ");
        lenght = reader.nextInt();
        int[] orderedArray = new int[Programm.lenght];
        int[] reversedArray = new int[Programm.lenght];
        int[] randomArray = new int[Programm.lenght];
        createList(orderedArray, reversedArray, randomArray, lenght);

        Map<String, int[]> list = new HashMap();

        list.put("geordnet", orderedArray);
        list.put("verkehrt geordnet", reversedArray);
        list.put("ungeordnet", randomArray);

        System.out.println("Insertionsort: ");
        for(int[] i : list.values()){
            long start = System.nanoTime();
            Sort_Algorithms.binaryInsertionSort(i);
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
            Sort_Algorithms.bubbleSort(i);
            long end = System.nanoTime();
            System.out.println("Das Sortieren der Liste: " + getKey(list, i) + " hat "+ (end-start) + " Nanosekunden gedauert");
        }
    }

    public static void schrittVergleich(){
        int listenLänge=0, listenBound=0;
        System.out.print("Listenlänge: ");
        listenLänge = reader.nextInt();
        System.out.print("Listenbound: ");
        listenBound = reader.nextInt();
        Random rnd = new Random();
        for(int i = 0; i <= 100; i++){
            List<Integer> temp = new ArrayList<>();

            while(i<=listenLänge){
                temp.add(rnd.nextInt(listenBound));
                i++;
            }

            sourceList.add(temp);
        }
        for (int o = 0; o < sourceList.size(); o++){
            allLists.add(new ArrayList<>());
            allLists2.add(new ArrayList<>());
            allLists3.add(new ArrayList<>());
            allLists4.add(new ArrayList<>());
            for (int in : sourceList.get(o)){
                allLists.get(o).add(Integer.valueOf(in));
                allLists2.get(o).add(Integer.valueOf(in));
                allLists3.get(o).add(Integer.valueOf(in));
                allLists4.get(o).add(Integer.valueOf(in));
            }
        }

        List<Integer> bubbleCount = new ArrayList<>();
        List<Integer> bubbleCount2 = new ArrayList<>();
        List<Integer> selectionCount = new ArrayList<>();
        List<Integer> selectionCount2 = new ArrayList<>();
        List<Integer> stableSelectionCount = new ArrayList<>();
        List<Integer> stableSelectionCount2 = new ArrayList<>();
        List<Integer> insertionCount = new ArrayList<>();
        List<Integer> insertionCount2 = new ArrayList<>();
        List<Long> time1 = new ArrayList<>();
        List<Long> time2 = new ArrayList<>();
        List<Long> time3 = new ArrayList<>();
        List<Long> time4 = new ArrayList<>();



        for (int o = 0; o< allLists.size(); o++){
            long start1 = System.nanoTime();
            Sort_Algorithms.bubbleSort(allLists.get(o));
            long end1 = System.nanoTime();
            bubbleCount.add(Sort_Algorithms.countVertausch.get("bubble_List"));
            bubbleCount2.add(Sort_Algorithms.countVergleich.get("bubble_List"));
            time1.add(end1-start1);

            long start2 = System.nanoTime();
            Sort_Algorithms.selectionsort(allLists2.get(o));
            long end2 = System.nanoTime();
            selectionCount.add(Sort_Algorithms.countVertausch.get("selection_List"));
            selectionCount2.add(Sort_Algorithms.countVergleich.get("selection_List"));
            time2.add(end2-start2);

            long start3 = System.nanoTime();
            Sort_Algorithms.stableSelectionSort(allLists3.get(o));
            long end3 = System.nanoTime();
            stableSelectionCount.add(Sort_Algorithms.countVertausch.get("stableSelection_List"));
            stableSelectionCount2.add(Sort_Algorithms.countVergleich.get("stableSelection_List"));
            time3.add(end3-start3);

            long start4 = System.nanoTime();
            Sort_Algorithms.binaryInsertionSort(allLists4.get(o));
            long end4 = System.nanoTime();
            insertionCount.add(Sort_Algorithms.countVertausch.get("insertion_List"));
            insertionCount2.add(Sort_Algorithms.countVergleich.get("insertion_List"));
            time4.add(end4-start4);


            Sort_Algorithms.countVertausch.clear();
            Sort_Algorithms.countVergleich.clear();

        }

        int allcounts=0, allcounts2=0, allcounts3=0, allcounts4=0;
        int all2counts=0, all2counts2=0, all2counts3=0, all2counts4=0;
        long alltime1=0, alltime2=0, alltime3=0, alltime4=0;

        for (int j = 0; j<bubbleCount.size(); j++){
            allcounts += bubbleCount.get(j);
            all2counts += bubbleCount2.get(j);
            allcounts2 += selectionCount.get(j);
            all2counts2 += selectionCount2.get(j);
            allcounts3 += stableSelectionCount.get(j);
            all2counts3 += stableSelectionCount2.get(j);
            allcounts4 += insertionCount.get(j);
            all2counts4 += insertionCount2.get(j);
            alltime1 += time1.get(j);
            alltime2 += time2.get(j);
            alltime3 += time3.get(j);
            alltime4 += time4.get(j);

        }

        System.out.println("Statistiken: ");
        System.out.println("Durchschnittliche Vergleichs-Operationen - Bubblesort: " + allcounts/bubbleCount.size());
        System.out.println("Durchschnittliche Vertausch-Operationen - Bubblesort: " + all2counts/bubbleCount2.size());
        System.out.println("Median - Bubblesort: " + bubbleCount2.get(bubbleCount2.size()/2));
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Bubblesort: " + alltime1/time1.size());
        System.out.println("Durchschnittliche Vergleichs-Operationen - Selectionsort: " + allcounts2/selectionCount.size());
        System.out.println("Durchschnittliche Vertausch-Operationen - Selectionsort: " + all2counts2/selectionCount2.size());
        System.out.println("Median - Selectionsort: " + selectionCount2.get(selectionCount2.size()/2));
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Selectionsort: " + alltime2/time2.size());
        System.out.println("Durchschnittliche Vergleichs-Operationen - Stable Selectionsort: " + allcounts3/stableSelectionCount.size());
        System.out.println("Durchschnittliche Vertausch-Operationen - Stable Selectionsort: " + all2counts3/stableSelectionCount2.size());
        System.out.println("Median - Stable Selectionsort: " + stableSelectionCount2.get(stableSelectionCount2.size()/2));
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Stable Selectionsort: " + alltime3/time3.size());
        System.out.println("Durchschnittliche Vergleichs-Operationen - Insertionsort: " + allcounts4/insertionCount.size());
        System.out.println("Durchschnittliche Vertausch-Operationen - Insertionsort: " + all2counts4/insertionCount2.size());
        System.out.println("Median - Insertionsort: " + insertionCount2.get(insertionCount2.size()/2));
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Insertionsort: " + alltime4/time4.size());
        System.out.println("Länge der Listen: " + listenLänge);
        System.out.println("Bound jeder Liste: " + listenBound);


    }



    static void createList(int[] orderedArray, int[] reversedArray, int[] randomArray, int lenght){
        Random rnd = new Random(Programm.lenght);
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

    //methode aus dem Internet
    public static <K, V> K getKey(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

}
