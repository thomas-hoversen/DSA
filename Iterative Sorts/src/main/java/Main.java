import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] test = new int[5];
        test[0] = 5; test[1] = 4; test[2] = 3; test[3] = 2; test[4] = 1;

        int[] test1 = new int[5];
        test1[0] = 1; test1[1] = 2; test1[2] = 3; test1[3] = 4; test1[4] = 5;

        printArray(test);
        System.out.println("");
        System.out.println("Selection sort test.");
        selectionSort(test);
    }


    public static void printArray(int[] array) {

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {

            if (i == array.length - 1) System.out.print(array[i]);
            else System.out.print(array[i] + ", ");
        }
        System.out.print("]");
    }

    public static void selectionSort(int[] arr) {
        /** comparator.compare(A, B) will return:

         < 0 if A is less than B
         > 0 if A is greater than B
         0 if A is equal to B */
        int count = 0;
        for (int n = arr.length - 1; n > 0; n--) {
            int maxIdx = 0;
            for (int i = 1; i <= n; i++) {
                count++;
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
            int a = arr[n];
            arr[n] = arr[maxIdx];
            arr[maxIdx] = a;
        }
        printArray(arr);
        System.out.println("");
        System.out.println("Counts: " + count);
    }

}
