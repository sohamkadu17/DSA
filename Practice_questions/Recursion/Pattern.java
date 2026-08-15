package Practice_questions.Recursion;

public class Pattern {
    public static void main(String[] args){
        pat(4,0);
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
}
