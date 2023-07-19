import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        ArrayList<T> preorderList = new ArrayList<T>();
        preorderList = preorderHelper(root, preorderList);
        return preorderList;
    }

    private ArrayList<T> preorderHelper(TreeNode<T> root, ArrayList<T> preorderList) {
        if (root != null) {
            preorderList.add(root.getData());
            preorderHelper(root.getLeft(), preorderList);
            preorderHelper(root.getRight(), preorderList);
        }
        return preorderList;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> inorderList = new ArrayList<T>();
        inorderList = inorderHelper(root, inorderList);
        return inorderList;
    }

    private ArrayList<T> inorderHelper(TreeNode<T> root, ArrayList<T> inorderList) {
        if (root != null) {
            inorderHelper(root.getLeft(), inorderList);
            inorderList.add(root.getData());
            inorderHelper(root.getRight(), inorderList);
        }
        return inorderList;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> postorderList = new ArrayList<T>();
        postorderList = postorderHelper(root, postorderList);
        return postorderList;
    }

    private ArrayList<T> postorderHelper(TreeNode<T> root, ArrayList<T> postorderList) {
        if (root != null) {
            postorderHelper(root.getLeft(), postorderList);
            postorderHelper(root.getRight(), postorderList);
            postorderList.add(root.getData());
        }
        return postorderList;
    }


}
