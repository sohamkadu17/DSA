package soham;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(2, 3));
        path("", 2, 3);
    }

    private static int count(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int right = count(r-1,c);
        int left = count(r,c-1);

        return right +left;
    }

    private static void path(String p ,int r , int c){
        if( r==1 && c ==1){
            System.out.println(p);
            return;
        }

        if(r> 1){
            path(p+"D",r-1,c);
        }
        if(c> 1){
            path(p+"R",r,c-1);
        }
    }

}
