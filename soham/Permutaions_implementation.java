package soham;

public class Permutaions_implementation {
    

    private static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0; i<= p.length(); i++){
            String s = p.substring(0,i);
            String l = p.substring(i,p.length());
            permutations(l+ch+s, up.substring(1));
        }

    }



    public static void main(String[] args){
        String s = "ABC";
        System.out.println("The Permutations of the String are : ");
        permutations("", s);
    }
}
