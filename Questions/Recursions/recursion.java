package Questions.Recursions;

public class recursion {

    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));
    }



    public static  int numberOfSteps(int num) {
        int count = 0;
        count = numSteps(num,count);
        return count;
    }

    private static int numSteps(int num , int count){
        if(num == 0){
            return count;
        }
        if(num%2 == 0){
            num = num/2;
            count ++;
            return numSteps(num, count);
        }else{
            num = num-1;
            count ++;
            return numSteps(num, count);
        }


        
    }

}
