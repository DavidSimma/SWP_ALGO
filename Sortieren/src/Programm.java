import java.util.*;

public class Programm {
    public static int lenght;
    public static Scanner reader = new Scanner(System.in);
    public static List<List<Integer>> sourceList = new ArrayList<>();
    public static List<List<Integer>> allLists = new ArrayList<>();
    public static List<List<Integer>> allLists2 = new ArrayList<>();
    public static List<List<Integer>> allLists3 = new ArrayList<>();
    public static List<List<Integer>> allLists4 = new ArrayList<>();
    public static List<List<Integer>> allLists5 = new ArrayList<>();

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
            Sort_Algorythm.binaryInsertionSort(i);
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
            Sort_Algorythm.bubbleSort(i);
            long end = System.nanoTime();
            System.out.println("Das Sortieren der Liste: " + getKey(list, i) + " hat "+ (end-start) + " Nanosekunden gedauert");
        }
    }

    public static void createSourceList(int listenLänge, int listenBound, int listenAnzahl){
        Random rnd = new Random();
        for(int i = 0; i < listenAnzahl; i++){
            List<Integer> temp = new ArrayList<>();
            int o=0;
            while(o<listenLänge){
                temp.add(rnd.nextInt(listenBound));
                o++;
            }

            sourceList.add(temp);
        }
    }

    public static void deepCopyLists(){
        for(List<Integer> in : sourceList){
            allLists.add(new ArrayList<>());
            allLists2.add(new ArrayList<>());
            allLists3.add(new ArrayList<>());
            allLists4.add(new ArrayList<>());
            allLists5.add(new ArrayList<>());
        }
        for(List<Integer> on : sourceList){
            for (int o = 0; o <sourceList.size(); o++) {
                for (int i = 0; i < on.size(); i++) {
                    allLists.get(o).add(on.get(i));
                    allLists2.get(o).add(on.get(i));
                    allLists3.get(o).add(on.get(i));
                    allLists4.get(o).add(on.get(i));
                    allLists5.get(o).add(on.get(i));
                }
            }
        }

    }

    public static void schrittVergleich(){
        int listenLänge=0, listenBound=0, listenAnzahl=0;
        System.out.print("Listenlänge: ");
        listenLänge = reader.nextInt();
        System.out.print("Listenbound: ");
        listenBound = reader.nextInt();
        System.out.print("Anzahl Listen: ");
        listenAnzahl = reader.nextInt();

        createSourceList(listenLänge, listenBound, listenAnzahl);

        deepCopyLists();

        List<Integer> bubbleCount = new ArrayList<>();
        List<Integer> bubbleCount2 = new ArrayList<>();
        List<Integer> selectionCount = new ArrayList<>();
        List<Integer> selectionCount2 = new ArrayList<>();
        List<Integer> stableSelectionCount = new ArrayList<>();
        List<Integer> stableSelectionCount2 = new ArrayList<>();
        List<Integer> insertionCount = new ArrayList<>();
        List<Integer> insertionCount2 = new ArrayList<>();
        List<Integer> quickCount = new ArrayList<>();
        List<Integer> quickCount2 = new ArrayList<>();
        List<Long> time1 = new ArrayList<>();
        List<Long> time2 = new ArrayList<>();
        List<Long> time3 = new ArrayList<>();
        List<Long> time4 = new ArrayList<>();
        List<Long> time5 = new ArrayList<>();

        for (int o = 0; o< allLists.size(); o++){


            long start1 = System.nanoTime();
            Sort_Algorythm.bubbleSort(allLists.get(o));
            long end1 = System.nanoTime();
            bubbleCount.add(Sort_Algorythm.countVertausch.get("bubble_List"));
            bubbleCount2.add(Sort_Algorythm.countVergleich.get("bubble_List"));
            time1.add(end1-start1);
            System.out.println(o);

            long start2 = System.nanoTime();
            Sort_Algorythm.selectionsort(allLists2.get(o));
            long end2 = System.nanoTime();
            selectionCount.add(Sort_Algorythm.countVertausch.get("selection_List"));
            selectionCount2.add(Sort_Algorythm.countVergleich.get("selection_List"));
            time2.add(end2-start2);
            System.out.println(o);


            long start3 = System.nanoTime();
            Sort_Algorythm.stableSelectionSort(allLists3.get(o));
            long end3 = System.nanoTime();
            stableSelectionCount.add(Sort_Algorythm.countVertausch.get("stableSelection_List"));
            stableSelectionCount2.add(Sort_Algorythm.countVergleich.get("stableSelection_List"));
            time3.add(end3-start3);
            System.out.println(o);


            long start4 = System.nanoTime();
            Sort_Algorythm.binaryInsertionSort(allLists4.get(o));
            long end4 = System.nanoTime();
            insertionCount.add(Sort_Algorythm.countVertausch.get("insertion_List"));
            insertionCount2.add(Sort_Algorythm.countVergleich.get("insertion_List"));
            time4.add(end4-start4);
            System.out.println(o);


            long start5 = System.nanoTime();
            Sort_Algorythm.quickSort(allLists5.get(o), 0, allLists5.size()-1);
            long end5 = System.nanoTime();
            quickCount.add(Sort_Algorythm.countVertausch.get("quick_List"));
            quickCount2.add(Sort_Algorythm.countVergleich.get("quick_List"));
            time5.add(end5-start5);
            System.out.println(o);


            Sort_Algorythm.countVertausch.clear();
            Sort_Algorythm.countVergleich.clear();

        }

        int allcounts=0, allcounts2=0, allcounts3=0, allcounts4=0, allcounts5=0;
        int all2counts=0, all2counts2=0, all2counts3=0, all2counts4=0, all2counts5=0;
        long alltime1=0, alltime2=0, alltime3=0, alltime4=0, alltime5=0;

        for (int j = 0; j<bubbleCount.size(); j++){
            allcounts += bubbleCount.get(j);
            all2counts += bubbleCount2.get(j);
            allcounts2 += selectionCount.get(j);
            all2counts2 += selectionCount2.get(j);
            allcounts3 += stableSelectionCount.get(j);
            all2counts3 += stableSelectionCount2.get(j);
            allcounts4 += insertionCount.get(j);
            all2counts4 += insertionCount2.get(j);
            allcounts5 += quickCount.get(j);
            all2counts5 += quickCount2.get(j);
            alltime1 += time1.get(j);
            alltime2 += time2.get(j);
            alltime3 += time3.get(j);
            alltime4 += time4.get(j);
            alltime5 += time5.get(j);

        }

        System.out.println("Statistiken: ");

        System.out.println("\nBubblesort");
        System.out.println("Durchschnittliche Vergleichs-Operationen - Bubblesort: " + allcounts/bubbleCount.size()/listenAnzahl);
        System.out.println("Durchschnittliche Vertausch-Operationen - Bubblesort: " + all2counts/bubbleCount2.size()/listenAnzahl);
        System.out.println("Median - Bubblesort: " + bubbleCount2.get(bubbleCount2.size()/2)/listenAnzahl);
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Bubblesort: " + alltime1/time1.size()/listenAnzahl);

        System.out.println("\nSelectionsort");
        System.out.println("Durchschnittliche Vergleichs-Operationen - Selectionsort: " + allcounts2/selectionCount.size()/listenAnzahl);
        System.out.println("Durchschnittliche Vertausch-Operationen - Selectionsort: " + all2counts2/selectionCount2.size()/listenAnzahl);
        System.out.println("Median - Selectionsort: " + selectionCount2.get(selectionCount2.size()/2)/listenAnzahl);
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Selectionsort: " + alltime2/time2.size()/listenAnzahl);

        System.out.println("\nStable Selectionsort");
        System.out.println("Durchschnittliche Vergleichs-Operationen - Stable Selectionsort: " + allcounts3/stableSelectionCount.size()/listenAnzahl);
        System.out.println("Durchschnittliche Vertausch-Operationen - Stable Selectionsort: " + all2counts3/stableSelectionCount2.size()/listenAnzahl);
        System.out.println("Median - Stable Selectionsort: " + stableSelectionCount2.get(stableSelectionCount2.size()/2)/listenAnzahl);
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Stable Selectionsort: " + alltime3/time3.size()/listenAnzahl);

        System.out.println("\nInsertionsort");
        System.out.println("Durchschnittliche Vergleichs-Operationen - Insertionsort: " + allcounts4/insertionCount.size()/listenAnzahl);
        System.out.println("Durchschnittliche Vertausch-Operationen - Insertionsort: " + all2counts4/insertionCount2.size()/listenAnzahl);
        System.out.println("Median - Insertionsort: " + insertionCount2.get(insertionCount2.size()/2)/listenAnzahl);
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Insertionsort: " + alltime4/time4.size()/listenAnzahl);

        System.out.println("\nQuicksort");
        System.out.println("Durchschnittliche Vergleichs-Operationen - Quicksort: " + allcounts5/quickCount.size()/listenAnzahl);
        System.out.println("Durchschnittliche Vertausch-Operationen - Quicksort: " + all2counts5/quickCount2.size()/listenAnzahl);
        System.out.println("Median - Quicksort: " + quickCount2.get(quickCount2.size()/2)/listenAnzahl);
        System.out.println("Durchschnittliche Zeit (Nanosekunden) - Quicksort: " + alltime5/time5.size()/listenAnzahl);

        System.out.println();
        System.out.println("Länge der Listen: " + listenLänge);
        System.out.println("Bound jeder Liste: " + listenBound);

        System.out.println(Sort_Algorythm.countVergleich.get("quick_List"));
        System.out.println(Sort_Algorythm.countVertausch.get("quick_List"));
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

