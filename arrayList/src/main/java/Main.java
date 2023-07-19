public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        ArrayList<Integer> arr = new ArrayList<>();
        arr.addToBack(5);
        arr.addToBack(4);
        arr.addToBack(3);
        arr.addToBack(2);
        arr.addToBack(1);

        System.out.println(arr.size());
        System.out.println(arr.toString());

        arr.addToFront(0);
        arr.addToFront(0);
        arr.addToFront(0);
        arr.addToFront(0);
        arr.addToFront(0);
        arr.addToFront(0);

        System.out.println(arr.size());

        System.out.println(arr.toString());

        Integer t = arr.removeFromBack();

        System.out.println(arr.size());
        System.out.println(t);
        System.out.println(arr.toString());

        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
        t = arr.removeFromFront();
        System.out.println(t);
        System.out.println(arr.toString());
    }
}
