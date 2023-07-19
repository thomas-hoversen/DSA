import java.util.Comparator;

public class Main2 {

    public static void main(String[] args) {
        System.out.println("Hello, world");
        int[] arr = {5, 4, 3, 1, 2};
        printArray(arr);
        System.out.println(" ");
        selectionSort(arr);
        printArray(arr);

    }

    private static void selectionSort(int[] arr) {
        for (int i = arr.length -1; i > 0; i--) {
            int maxIdx = 0;

            for (int k = 1; k <= i; k++) {
                if (arr[k] > arr[maxIdx]) { //  arr[i] > arr[maxIdx]
                    maxIdx = k;
                }
            }
            int val = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = val;

        }


    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {

        for (int i = arr.length -1; i > 0; i--) {
            int maxIdx = 0;

            for (int k = 1; k <= i; k++) {
                if (comparator.compare(arr[i], arr[maxIdx]) > 0) { //  arr[i] > arr[maxIdx]
                    maxIdx = i;
                }
            }
            T val = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = val;

        }


    }



}
