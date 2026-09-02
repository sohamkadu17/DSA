package Trees;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {1, 3, -7, 3, 56, 34};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println("Displaying the tree");
        tree.display();
    }

    private class Node {

        private Node left;
        private Node right;
        private int value;
        private int height;
        private int startInterval;
        private int endInterval;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    Node root;

    public SegmentTree(int[] arr) {
        // create a tree using this arr;
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }
        // create a new node with index you currently at

        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.value = node.left.value + node.right.value;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data = " + node.left.value + " +->";
        } else {
            str = str + "No left child ";
        }
        str = str + "interval=[" + node.startInterval + "-" + node.endInterval + "] and data = " + node.value + "+ ->";

        if (node.right != null) {
            str = str + "interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data = " + node.right.value + "+ ->";
        } else {
            str = str + "No right child ";
        }
        // for current node 
        System.out.println(str);
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }

    }

    public int query(int starti, int endi) {
        return query(this.root, starti, endi);
    }

    private int query(Node node, int si, int ei) {
        if (node.startInterval >= si && node.endInterval <= ei) {
            return node.value;
        }

        if (node.startInterval >= si && node.endInterval <= ei) {
            return node.value;
        } else if (node.startInterval >= ei && node.endInterval <= si) {
            return 0;
        } else {
            return this.query(node.left, si, ei) + this.query(node.right, si, ei);
        }
    }

    public void update(int index, int value) {
        this.root.value = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.value = value;
                return node.value;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.value = leftAns + rightAns;
                return node.value;
            }
        }
        return node.value;
    }
}
