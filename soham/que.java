package soham;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;


public class que {
    public static void main(String[] args) {
        Queue<Integer> sc = new LinkedList<>();
        sc.add(23);
        sc.add(21);
        sc.add(24);
        sc.add(27);
        System.out.println(sc.remove());
        //  remove Poll are also some methods used in que.
        // Dequeue is used to insert and remove from both the ends of the queue


        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(23);
        deque.addLast(24);
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
    }
}
