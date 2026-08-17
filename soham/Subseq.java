package soham;

import java.util.ArrayList;
import java.util.List;

public class Subseq{
    // Using recursion to print all the subsequences of a string;
   private static void Sub(String str, String up){
        if(str.isEmpty()){
            System.out.println(up);
            return;
        }
        char ch = str.charAt(0);
        Sub(str.substring(1),up +ch );
        Sub(str.substring(1),up);
        
    }

    //  now what if we want to return an arrayList of all subsequences of string;

    private static ArrayList<String> SubA(String str, String up){
        if(str.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(up);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = SubA(str.substring(1), up+ch);
        ArrayList<String> right = SubA(str.substring(1), up);

        left.addAll(right);

        return left;
    }


    //  now It want to also print the ascii values of the character in the subsequence of the string;
    private static void SubAscii(String str, String up){
        if(str.isEmpty()){
            System.out.println(up);
            return;
        }
        char ch = str.charAt(0);
        SubAscii(str.substring(1), up+ch);
        SubAscii(str.substring(1), up);
        SubAscii(str.substring(1), up+(ch + 0));
    }


    //  Now what If arrayList is expected to be returned with the acii values of the character in the subsequence of the string;

    private static ArrayList<String> SubAsciiA(String str, String up){
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }

        char ch = str.charAt(0);
        ArrayList<String> first = SubAsciiA(str.substring(1), up+ch);
        ArrayList<String> second = SubAsciiA(str.substring(1), up);
        ArrayList<String> third= SubAsciiA(str.substring(1), up+(ch + 0));

        first.addAll(second);
        first.addAll(third);
        return first;
    }



    //  Iterative approach to find all the subsequences of an array integer array;

    private static List<List<Integer>> SubSet(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n = outer.size();
            for(int i = 0; i< n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }



    //  now To Avoid Duplicates in this Subset;

    private static List<List<Integer>> SubSetDup(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0 ; i< arr.length; i++){
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size() -1;
            int n = outer.size();
            for(int j= start; j<n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }


    public static void main(String[] args){
        Sub("abc", "");
        // ArrayList<String> ans = SubA("abc", "");
        // System.out.print(ans);
        // SubAscii("abc", "");
        // ArrayList<String> ans2 = SubAsciiA("abc", "");
        // System.out.print(ans2);
        List<List<Integer>> ans3 = SubSet(new int[]{1, 2, 3});
        System.out.print(ans3);

    }
}