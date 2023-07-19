import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    public void stringifyHeap() {
        System.out.print("[ ");
        for(int i = 0; i < backingArray.length; i++) {
            System.out.print(backingArray[i] + " ");
        }
        System.out.print("]");
    }

    // build larger array function
    private T[] resizeArray() {
        T[] newArray = (T[]) new Comparable[backingArray.length * 2];
        for (int i = 0; i < backingArray.length; i++) {
            newArray[i] = backingArray[i];
        }
        return newArray;
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {

        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }

        if (backingArray.length - 1 == size) {
            backingArray = resizeArray();
        }

        // add to end of array
        backingArray[size + 1] = data;
        size++;

        // heapify logic
        int curr = size;
        boolean continueHeap = true;
        while (curr/2 != 0 && continueHeap) {
            if (backingArray[curr/2].compareTo(backingArray[curr]) > 0) { // parent greater than child?
                T temp = backingArray[curr];
                backingArray[curr] = backingArray[curr/2];
                backingArray[curr/2] = temp;
            } else continueHeap = false; // no need to continue heapify.
            curr = curr / 2;
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {

        if (size == 0) {
            throw new NoSuchElementException("Heap is empty.");
        }

        T data = backingArray[1];

        // replace first item with last item
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;

        // heapify down
        int curr = 1;
        boolean continueHeap = true;
        while ((curr*2) <= size && backingArray[curr*2] != null && continueHeap) {
            T left = backingArray[curr*2];
            T right = null;

            // get right child, even if null
            if ((curr*2) + 1 <= size) {
                right = backingArray[(curr * 2) + 1];
            }

            if (right != null) { // 2 children to compare
                if (left.compareTo(right) < 0 && left.compareTo(backingArray[curr]) < 0) { // left child is smaller
//                    System.out.println("left: " + left);
//                    System.out.println("right: " + right);
//                    boolean t = left.compareTo(right) < 0;
//                    System.out.println("left.compareTo(right) < 0: " + t);
                    backingArray[curr*2] = backingArray[curr];
                    backingArray[curr] = left;
                    curr = curr*2;
                } else if (right.compareTo(left) < 0 && right.compareTo(backingArray[curr]) < 0) { // right child is smaller
//                    System.out.println("left: " + left);
//                    System.out.println("right: " + right);
//                    boolean t = left.compareTo(right) < 0;
//                    System.out.println("left.compareTo(right) < 0: " + t);
                    backingArray[(curr*2)+1] = backingArray[curr];
                    backingArray[curr] = right;
                    curr = (curr*2)+1;
                } else continueHeap = false;
            } else { // just left to compare
//                System.out.println("left: " + left);
//                System.out.println("right: " + right);
                //boolean t = left.compareTo(right) < 0;
                //System.out.println("left.compareTo(right) < 0: " + t);
                if (left.compareTo(backingArray[curr]) < 0) {
                    backingArray[curr*2] = backingArray[curr];
                    backingArray[curr] = left;
                    curr = curr*2;
                } else continueHeap = false;
            }
        }
        return data;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
