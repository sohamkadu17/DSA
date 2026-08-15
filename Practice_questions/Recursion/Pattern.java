package Practice_questions.Recursion;

public class Pattern {
    public static void main(String[] args){
        pat2(4,0);
        System.out.println();
        pat(5,0);
    }
    private static void pat(int row, int col){
        if(row == 0){
            return;
        }
        if(col<row){
            System.out.print("X ");
            pat(row,col+1);
        }else{
            System.out.println();
            pat(row-1, 0);
        }
    }

    private static void pat2(int row, int col){
        if(row == 0){
            return;
        }
        if(col<row){
            pat2(row,col+1);
            System.out.print("X ");
            
          
          
        }else{
        pat2(row-1,0);
        System.out.println();
        }
    }
}
