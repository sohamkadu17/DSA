package Questions.DailyLeetCode;


public class MaximumLenSubString {
    public static int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int maxLen = 0;
        int left = 0;
        
        for(int right = 0; right <s.length(); right++){
            char ch = s.charAt(right);
            freq[ch-'a']++;
            while(freq[ch - 'a'] > 2){
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            maxLen = Math.max(right-left+1, maxLen);
        }
        return maxLen;
    }
    
    public static void main(String[] args){
        String s = "bcbbbcba";

        System.out.println(maximumLengthSubstring(s));

    }
}   
