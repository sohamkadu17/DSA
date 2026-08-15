package Practice_questions.Maths;

public class Factors {
    public static void main(String [] args){
        int a = 16;
        int b = 4;
        System.out.println(LCM(a,b));
        System.out.println(gcd(a,b));
    }
    private static int LCM(int a,int b){
        return a*b/gcd(a,b);
    } 
    private static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(a%b , b);
    }
    
}
