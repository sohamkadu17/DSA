package Questions.DailyLeetCode;
import java.util.Arrays;


public class LongestSubstring{
    private static int repeatLen(String s){
        int maxLen = 0;
        int Len = 1;
        for(int i = 0 ; i<s.length()-1; i++){
            
            if(s.charAt(i) == s.charAt(i+1)){
                Len++;
                maxLen = Math.max(maxLen, Len);
            }else{
                Len = 1;
            }
            
        }
        return maxLen;
    }

    public static int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int []result = new int[queryIndices.length];
        char[] st = s.toCharArray();
        for(int i = 0; i<queryCharacters.length();i++){
            st[queryIndices[i]]= queryCharacters.charAt(i);
            String current = new String(st);
            result[i] = repeatLen(current);


        
            
        }
        return result;
    }

    public static void main(String[] args){
        String s = "babacc";
       String queryCharacters = "bcb";
       int[] queryIndices = {1, 3, 3};
        int[] arr = longestRepeating(s, queryCharacters, queryIndices);
        System.out.println(Arrays.toString(arr));

    }
}