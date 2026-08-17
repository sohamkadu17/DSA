package soham;

import java.util.ArrayList;

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


    public static void main(String[] args){
        Sub("abc", "");
        ArrayList<String> ans = SubA("abc", "");
        System.out.print(ans);
        SubAscii("abc", "");

    }
}