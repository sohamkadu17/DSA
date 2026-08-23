package soham;

import java.util.HashMap;

public class Hash {
    

    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<>();

    map.put("Soham", 1);
    map.put("Rohan", 3);
    map.put("SK", 2);
    map.put("Ram", 5);
    int val = map.get("Rohan");
    System.out.println(val);
    System.out.println(map.getOrDefault("Sohan", 76));
    }
}
