package Codeforces;
import java.util.Scanner;
public class FirstCase{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max_int = Integer.MIN_VALUE;
        int max_idx = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i<n;i++){
            arr[i] = sc.nextInt();
            if(arr[i] > max_int){
                max_int = arr[i];
                max_idx = i;
            }
        }
        System.out.println(max_idx+1);
        sc.close();
    }
}