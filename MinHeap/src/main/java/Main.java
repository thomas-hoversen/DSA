public class Main {

    public static void main(String[] args) {
        MinHeap<Integer> min = new MinHeap<>();
        min.add(0);
        min.add(7);
        min.add(14);
        min.add(21);
        min.add(28);
        min.add(35);
        min.add(42);
        min.add(56);
        min.add(49);
        min.add(63);
        min.stringifyHeap();
        System.out.println("");
        min.remove();
        min.stringifyHeap();
    }

}
