import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        /** comparator.compare(A, B) will return:

         < 0 if A is less than B
         > 0 if A is greater than B
         0 if A is equal to B */

        int stopIndex = arr.length - 1;
        boolean swapsMade = true;
        while (stopIndex != 0 && swapsMade) {
            swapsMade = false;
            int i = 0;
            int lastSwapped = stopIndex - 1;
            while (i < stopIndex) {

                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;
                    swapsMade = true;
                    lastSwapped = i;
                }

                i++;
            }
            stopIndex = lastSwapped;
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        /** comparator.compare(A, B) will return:

         < 0 if A is less than B
         > 0 if A is greater than B
         0 if A is equal to B */

        for (int n = arr.length - 1; n > 0; n--) {
            int maxIdx = 0;
            for (int i = 1; i <= n; i++) {
                if (comparator.compare(arr[i], arr[maxIdx]) > 0) {
                    maxIdx = i;
                }
            }
            T a = arr[n];
            arr[n] = arr[maxIdx];
            arr[maxIdx] = a;
        }

    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        /** comparator.compare(A, B) will return:

         < 0 if A is less than B
         > 0 if A is greater than B
         0 if A is equal to B */

        for (int n = 1; n < arr.length; n++) {
            int i = n;
            while (i > 0 && comparator.compare(arr[i], arr[i - 1]) < 0) {
                T a = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = a;
                i--;
            }
        }
    }
}
