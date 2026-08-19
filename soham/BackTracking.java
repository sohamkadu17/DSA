package soham;
import java.util.Arrays;

public class BackTracking {

    public static void main(String[] args) {
        int [][] matrix = {
           {0,0,0},
            {0,0,0},
            {0,0,0}
        };

        pathtaken(0,0,0,matrix);

    }

    private static void pathtaken(int Step , int r , int c , int [][] path){
        if(r==path.length-1 && c== path[0].length-1){
            for(int [] array : path){
                System.out.println(Arrays.toString(array));
            }
            System.out.println();
            return;
        }

        if(path[r][c] != 0){
            return;
        }
        path[r][c] = Step;

        if(r>0){
            pathtaken(Step+1,r-1,c,path);
        }
        if(c>0){
            pathtaken(Step+1,r,c-1,path);
        }
        if(c<path.length-1){
            pathtaken(Step+1,r,c+1,path);
        }
        if(r<path.length-1){
            pathtaken(Step+1,r+1,c,path);
        }

        path[r][c] =0;
    }

    private static void path(String p, boolean[][] Matrix, int r, int c) {
        if (r == Matrix.length-1  && c == Matrix[0].length-1) {
            System.out.println(p);
            return;
        }
        if (!Matrix[r][c]) {
            return;
        }

        Matrix[r][c] = false;
        if(r<Matrix.length -1){
            path(p+"D",Matrix,r+1,c);
        }
        if(c<Matrix[0].length-1){
            path(p+"R",Matrix,r,c+1);
        }
        if (r > 0) {
            path(p+"U",Matrix,r-1,c);
        }
        if (c > 0) {
            path(p+"L",Matrix,r,c-1);
        }
        Matrix[r][c] = true;

    }
}
