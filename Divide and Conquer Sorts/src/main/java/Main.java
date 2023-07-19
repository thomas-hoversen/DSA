import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        //System.out.println("Hello, World!");

        //System.out.println(3/2);

        //int[] arr = {9,1,7,2,5,3,4,9,1};
        int[] arr = {1, -2};
        //int[] arr = {-2147483648, -9, -2147483648};
        //int[] arr = {-2, -111, 1, 3};
//        int length = arr.length;
//        int midIndex = arr.length / 2;
//
//        int[] left = new int[midIndex]; // small_array
//        int[] right = new int[length - midIndex]; // big_array
//
//        for (int i = 0; i < arr.length/2; i++) {
//            left[i] = arr[i];
//        }
//        int k = 0;
//        for (int i = arr.length/2; i < arr.length; i++) {
//            right[k] = arr[i];
//            k++;
//        }

        printArray(arr);
        lsdRadixSort(arr);
        printArray(arr);

//        int l = (int)(Math.log10(3000)+1);
//        //System.out.println(l);
//
//        LinkedList<Integer>[] listArray = new LinkedList[19];
//
//        for (int i = 0; i < 19; i++) {
//            listArray[i] =  new LinkedList<Integer>();
//        }
//
//        listArray[-8+9].addLast(-1238);
//        listArray[-8+9].addLast(-2278);
//        System.out.println(listArray.length);
//        System.out.println(listArray[-8+9].removeFirst());
//        System.out.println(listArray[-8+9].removeFirst());
//        System.out.println(listArray[-8+9].size());
//        System.out.println("5%10:");
//        System.out.println(5%10);
//        System.out.println(567 % 10);
//        System.out.println(567/1);
//        System.out.println(567 / 10);
//        System.out.println(567 / 100);
//        System.out.println(567 / 1000);
    }

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");

    }

    public static void mergeSort(int[] arr) {

        if (arr.length == 1) {
            return;
        }

        int length = arr.length;
        int midIndex = arr.length / 2;

        int[] left = new int[midIndex]; // small_array
        int[] right = new int[length - midIndex]; // big_array

        for (int i = 0; i < arr.length/2; i++) {
            left[i] = arr[i];
        }
        int k = 0;
        for (int i = arr.length/2; i < arr.length; i++) {
            right[k] = arr[i];
            k++;
        }

        mergeSort(left);
        mergeSort(right);


        /**
         * comparator.compare(A, B) will return:
         *
         * < 0 if A is less than B
         * > 0 if A is greater than B
         * 0 if A is equal to B
         * */

        int i = 0;
        int j = 0;
//        printArray(left);
//        printArray(right);

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) { // left[i] <= right[j]
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


    public static void lsdRadixSort(int[] arr) {

        LinkedList[] listArray = new LinkedList[19];

        if (arr.length == 0) return; // new line for when passed in array is empty

        for (int i = 0; i < 19; i++) {
            listArray[i] =  new LinkedList<>();
        }
        // get longest number
        long max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            long a = arr[i];
            if (Math.abs(a) > Math.abs(max)) max = arr[i];
        }

        int r = 0;
        long temp = 1;
        while (temp <= Math.abs(max)) {
            r++;
            temp *= 10;
        }
        // length of longest number
        int k = r;
        int div = 1;

        for (int i = 0; i < k; i++) {

            for (int j = 0; j < arr.length; j++) {

                // calculate digit
                long a = arr[j];

                long b = a / div;
                int e = (int) b % 10;
                if (Math.abs(a) < div) e = 0;

                listArray[9+e].addLast(arr[j]);

            }

            // loop over buckets
            int idx = 0;
            for (int h = 0; h < 19; h++) {
                while (listArray[h].size() > 0) {
                    arr[idx++] = (int) listArray[h].removeFirst();
                }
            }

            div = div*10;

        }


    }



}

