import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, World.");

        TreeNode<Integer> root = new TreeNode<>(50);
        TreeNode<Integer> r25 = new TreeNode<>(25);
        TreeNode<Integer> r100 = new TreeNode<>(100);
        TreeNode<Integer> r10 = new TreeNode<>(10);
        TreeNode<Integer> r75 = new TreeNode<>(75);
        TreeNode<Integer> r125 = new TreeNode<>(125);
        TreeNode<Integer> r110 = new TreeNode<>(110);
        r125.setLeft(r110);
        r100.setRight(r125);
        r100.setLeft(r75);
        r25.setLeft(r10);
        root.setLeft(r25);
        root.setRight(r100);
        Traversals traverse = new Traversals();

        List<Integer> preorder = traverse.preorder(root);
        List<Integer> inorder = traverse.inorder(root);
        List<Integer> postorder = traverse.postorder(root);

        String preorderString = preorder.toString();
        System.out.println("Preorder string.");
        System.out.println(preorderString);
        // [50, 25, 10, 100, 75, 125, 110]

        String inorderString = inorder.toString();
        System.out.println("Inorder string.");
        System.out.println(inorderString);
        // [10, 25, 50, 75, 100, 110, 125]

        String postorderString = postorder.toString();
        System.out.println("Postorder string.");
        System.out.println(postorderString);
        // [10, 25, 75, 110, 125, 100, 50]


    }


}
