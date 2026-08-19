package soham;

public class ObsMaze {
    public static void main(String[] args){
        boolean[][] matrix = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
                };

            pathObs("",matrix,0,0);
        
        
    }

    private static void pathObs(String p, boolean[][] matrix, int r,int c){
        if(r == matrix.length-1&& c == matrix[0].length-1){
            System.out.println(p);
            return;
        } 
        if(!matrix[r][c]) {
            return;
        }
        if(r<matrix.length-1){ 
            pathObs(p+"D",matrix,r+1,c);
        }
        if(c<matrix[0].length -1){
            pathObs(p+"R",matrix,r,c+1);
        }
    }
}
