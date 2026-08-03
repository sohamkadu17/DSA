package soham;
public class LL {
    private Node Head;
    private Node Tail;

    private int size;
    public LL(){
        this.size = 0;
    }

    public void insertAt(int index, int value){
        
        if(index > size){
            System.out.println("Index out of bounds");
            return;
        }

        Node temp = new Node(value);
        Node current = Head;
        for(int i = 0 ; i<=index-1;i++){
            current = current.next;
        }
        temp.next = current.next;
        current.next = temp;
        size++;

    }


    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = Head;
        Head = node;
        size ++;

        if(Tail == null){
            Tail = Head;
        }

    }


    public void insertLast(int value){
        if(Tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        Tail.next = node;
        Tail = node;
    }

    public void display(){
        Node temp = Head;
        while(temp!=null){
            System.out.print( temp.value +"->");
            temp=temp.next;
        }
        System.out.println("End");
    }




    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
