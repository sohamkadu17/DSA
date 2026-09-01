package Trees;
// difference between a pareent and its child must <= 1

public class BST {

    private static class Node {

        private Node right;
        private Node left;
        private int value;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private Node root;

    public BST() {

    }

    public Node Insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = Insert(value, node.left);
        }
        if (value > node.value) {
           node.right=  Insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());

        display(node.left, "This is the Left child of " + node.getValue() + " :");
        display(node.right, "This is the Right child of " + node.getValue() + " :");
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return (Math.abs(height(node.left) - height(node.right)) <= 1) && balanced(node.left) && balanced(node.right);
    }

    public void insert(int n) {
        root = Insert(n, root);
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] num = {1,3,4,2,5,6,7,9};
        tree.populate(num);
        tree.display();
        System.out.println(tree.balanced());
    }

}
