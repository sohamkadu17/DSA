package soham;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(4, 4));
        // path("", 4, 4);
        System.out.println(pathRet("", 4, 4));
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

    private static ArrayList<String> pathRet(String p, int r , int c ){
        if(r==1 && c ==1 ){
            ArrayList<String>list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(pathRet(p+"D",r-1,c));

        }
        if(c>1){
            list.addAll(pathRet(p+"R", r,c-1));
        }



        return list;
    }

}
