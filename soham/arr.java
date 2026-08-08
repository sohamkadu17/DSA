package soham;
import java.util.ArrayList;

public class arr {

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6; 
        // Scanner sc = new Scanner(System.in);
        int[][] arr2 = new int[4][5];

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        // Methods in Array list ;


        list.contains(3);
        list.get(2);
        list.set(0, 5);;
        list.remove(2);
        list.size();
        System.out.println("array List is :" + list);
        list.isEmpty();
        list.clear();

        


        System.out.println("array List is :" + list);
        // System.out.println(java.util.Arrays.toString(arr));
        // System.out.println(java.util.Arrays.deepToString(arr2));
    }

}
