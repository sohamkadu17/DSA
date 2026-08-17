package Questions.Permutaion_leetcode;
import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// Google Phone Number to Letter Combinations


public class LetterCombo {
    private static List<String> help(String p, String up){
        List<String> list = new ArrayList<>();
         if(up.isEmpty()){
            System.out.println(p);
            list.add(p);
            return list;
        }

        String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        int digit = up.charAt(0) - '0';
        String Letters = keypad[digit];

        for(int i =0; i<Letters.length();i++){
            char ch = Letters.charAt(i);
            list.addAll(help(p + ch, up.substring(1)));
        }
        return list;

    }

    public static void main(String[] args){
        String s = "79";
        System.out.println("The Letter Combinations of the String are : ");
        System.out.println(help("", s));
    }


}
