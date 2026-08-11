package soham;

import java.util.Stack;

public class Stck {

    protected int[] data;
    private static final int defaultsize = 10;

    public Stck(int size) {
        this.data = new int[size];
    }

    public Stck(){
        this(defaultsize);
    }

     
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(9);
        s.push(2);
        

System.out.println(s.pop());
}
