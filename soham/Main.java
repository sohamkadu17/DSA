package soham;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(35);
        list.insertFirst(25);
        list.insertFirst(15);
        list.display();
        list.insertLast(24);
        list.insertLast(78);
        list.display();
        list.insertAt(56,90);
        list.display();
    }
}
