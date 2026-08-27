package Sliding_Window;
// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/?envType=daily-question&envId=2026-08-26
// 2904 Shortes Beautiful Lexicographical String


public class ShortestBeauti{
    public static void main(String [] args){
        String s = "1011";
        System.out.println(shortestBeautifulSubstring(s,2));
    }

    public static String shortestBeautifulSubstring(String s, int k){
        String ans = "";
        int left = 0;
        int ones = 0;
        for(int right = 0;right < s.length(); right++){
            if(s.charAt(right) == '1'){
                ones++;
            }
            while(ones>k){
                if(s.charAt(left) == '1'){
                    ones--;
                }
                left++;
            }
            while(ones == k && s.charAt(left) == '0'){
                left++;
            }
            if(ones == k){
                String c = s.substring(left, right+1);
                if(ans.isEmpty() || c.length() < ans.length() ||(ans.length() == c.length() && c.compareTo(ans)<0)){
                    ans =c;
                }

            }


        }
        return ans;
    }

}