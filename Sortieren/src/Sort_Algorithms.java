import java.util.HashMap;
import java.util.List;

public class Sort_Algorithms {
    public static HashMap<String, Integer> countVertausch = new HashMap<>();
    public static HashMap<String, Integer> countVergleich = new HashMap<>();

    public static void bubbleSort(int[] list) {
        countVertausch.put("bubble_Array",0);
        countVergleich.put("bubble_Array",0);

        int temp = 0;
        for(int i=0; i < list.length; i++){
            for(int j=1; j < (list.length-i); j++){
                countVergleich.put("bubble_Array", countVergleich.get("bubble_Array")+1);
                if(list[j-1] > list[j]){
                    temp = list[j-1];
                    list[j-1] =  list[j];
                    list[j] =  temp;
                    countVertausch.put("bubble_Array", countVertausch.get("bubble_Array")+1);
                }
            }
        }
    }
    public static void bubbleSort(List<Integer> list) {
        countVertausch.put("bubble_List",0);
        countVergleich.put("bubble_List",0);
        int temp = 0;
        for(int i=0; i < list.size(); i++){
            for(int j=1; j < (list.size()-i); j++){
                countVergleich.put("bubble_List", countVergleich.get("bubble_List")+1);
                if(list.get(j-1) > list.get(j)){
                    temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                    countVertausch.put("bubble_List", countVertausch.get("bubble_List")+1);
                }
            }
        }
    }
    public static void binaryInsertionSort(int[] array) {
        countVertausch.put("insertion_Array",0);
        countVergleich.put("insertion_Array",0);
        int length = array.length;

        for (int i = 1; i < length; ++i) {
            int key = array[i];
            int insertedPosition = findPosition(array, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                array[j + 1] = array[j];
                countVertausch.put("insertion_Array", countVertausch.get("insertion_Array")+1);
            }
            array[insertedPosition] = key;
        }
    }
    public static void binaryInsertionSort(List<Integer> list) {
        countVertausch.put("insertion_List",0);
        countVergleich.put("insertion_List",0);
        int length = list.size();

        for (int i = 1; i < length; ++i) {
            int key = list.get(i);
            int insertedPosition = findPosition(list, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                list.set(j + 1,list.get(j));
                countVertausch.put("insertion_List", countVertausch.get("insertion_List")+1);
            }
            list.set(insertedPosition, key);
        }
    }
    private static int findPosition(List<Integer> list, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            countVergleich.put("insertion_List", countVergleich.get("insertion_List")+1);

            if (key < list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
    private static int findPosition(int[] array, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            countVergleich.put("insertion_List", countVergleich.get("insertion_List")+1);

            if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
    public static void selectionsort(List<Integer> sortieren) {
        countVertausch.put("selection_List",0);
        countVergleich.put("selection_List",0);
        for (int i = 0; i < sortieren.size() - 1; i++) {
            for (int o = i + 1; o < sortieren.size(); o++) {
                countVergleich.put("selection_List", countVergleich.get("selection_List")+1);

                if (sortieren.get(i) > sortieren.get(o)) {
                    int temp = sortieren.get(i);
                    sortieren.set(i, sortieren.get(o));
                    sortieren.set(o, temp);
                    countVertausch.put("selection_List", countVertausch.get("selection_List")+1);

                }
            }
        }
    }
    void selectionsort(int arr[])
    {
        countVertausch.put("selection_Array",0);
        countVergleich.put("selection_Array",0);
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                countVergleich.put("selection_Array", countVergleich.get("selection_Array")+1);

                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                    countVertausch.put("selection_Array", countVertausch.get("selection_Array")+1);
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void stableSelectionSort(List<Integer> a) {
        countVertausch.put("stableSelection_List",0);
        countVergleich.put("stableSelection_List",0);

        for (int i = 0; i < a.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.size(); j++) {
                countVergleich.put("stableSelection_List", countVergleich.get("stableSelection_List")+1);

                if (a.get(min) > a.get(j)) {
                    min = j;
                    countVertausch.put("stableSelection_List", countVertausch.get("stableSelection_List")+1);
                }
            }
            int key = a.get(min);

            while (min > i) {
                a.set(min, a.get(min - 1));
                min--;
                countVertausch.put("stableSelection_List", countVertausch.get("stableSelection_List")+1);
            }

            a.set(i, key);
        }
    }
    static void stableSelectionSort(int[] a, int n)
    {
        countVertausch.put("stableSelection_Array",0);
        for (int i = 0; i < n - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                    countVertausch.put("stableSelection_Array", countVertausch.get("stableSelection_Array")+1);
                }
            }

            int key = a[min];
            while (min > i)
            {
                a[min] = a[min - 1];
                min--;
                countVertausch.put("stableSelection_Array", countVertausch.get("stableSelection_Array")+1);
            }

            a[i] = key;
        }
    }
}
