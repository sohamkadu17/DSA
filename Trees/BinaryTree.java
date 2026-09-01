package Trees;
import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    private Node root;
    public void populate(Scanner Scanner){
        System.out.println("Enter the root node: ");
        int value = Scanner.nextInt();
        root = new Node(value);
        populate(Scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("do you want to enter Left of "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of "+ node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("do you want to enter right of "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of "+ node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }
    public void display(){
        preetydisplay(root, 0);
    }
    private void display(Node node, String s){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        display(node.left, s+"\t");
        display(node.right, s+"\t");

    }

    private void preetydisplay(Node node, int level){
        if(node == null){
            return;
        }


        preetydisplay(node.right, level+1);
        if(level != 0){
            for(int i = 0; i< level; i++){
                System.out.print("\t\t");
            }
            System.out.println("|--->"+node.value);
        }else{
            System.out.println(node.value);
        }
        preetydisplay(node.left, level+1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}
