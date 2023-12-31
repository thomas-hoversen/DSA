import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {

        if (arr.length == 1) {
            return;
        }

        int length = arr.length;
        int midIndex = arr.length / 2;

        T[] left = (T[]) new Object[midIndex]; // small_array
        T[] right = (T[]) new Object[length - midIndex]; // big_array

        for (int i = 0; i < arr.length/2; i++) {
            left[i] = arr[i];
        }
        int k = 0;
        for (int i = arr.length/2; i < arr.length; i++) {
            right[k] = arr[i];
            k++;
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) { // left[i] <= right[j]
                arr[i + j] = left[i];
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }

        while (i < left.length) {
            arr[i+j] = left[i];
            i++;
        }
         while (j < right.length) {
             arr[i + j] = right[j];
             j++;
         }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {

        LinkedList[] listArray = new LinkedList[19];

        for (int i = 0; i < 19; i++) {
            listArray[i] =  new LinkedList<>();
        }

        // get longest number
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max) max = arr[i];
        }

        int r = 0;
        int temp = 1;
        while (temp <= max) {
            r++;
            temp *= 10;
        }
        // length of longest number
        int k = r;
        int div = 1;
        for (int i = 0; i < k; i++) {

            for (int j = 0; j < arr.length; j++) {

                // calculate digit
                int b = arr[j] / div;
                int e = b % 10;

                listArray[9+e].addLast(arr[j]);

            }

            // loop over buckets
            int idx = 0;
            for (int h = 0; h < 19; h++) {
                //System.out.println("listArray.size(): " + listArray[h].size() + " at index: " + h);
                while (listArray[h].size() > 0) {
                    arr[idx++] = (int) listArray[h].removeFirst();
                }
            }

            div = div*10;

        }


    }
}
