package Practice_questions.BitManupulation;

public class one {
    private static boolean isOdd(int n){
        return (n&1) == 1;
    }
    // find the number which occurs only once in array which has all other elements occuring twice

    private static int ans(int[] arr){
        int unique = 0;
        for(int num: arr){
            unique ^= num;
    }
        return unique;
    }



    // find the nth bit of the number
    private static int nth(int num, int idx){
        int bit = 1<<idx-1;

        return num & bit;
    }


    public static void main(String[] args){
        // Tell if the binary number is even or odd;
        int n = 4;
        int[] arr = {1,2,3,4,5,6,5,4,3,2,1};
        System.out.println(isOdd(n));
        System.out.println(ans(arr));

        System.out.println(nth(n, 3));
    }
}
