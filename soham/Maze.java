package soham;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(2, 3));
    }

    private static int count(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int right = count(r-1,c);
        int left = count(r,c-1);

        return right +left;
    }
}
