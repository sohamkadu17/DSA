package soham;

import java.util.HashMap;
import java.util.HashSet;

public class Hash {
    // Tree map and map are snot implemented so do check that ;
    

    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<>();

    map.put("Soham", 1);
    map.put("Rohan", 3);
    map.put("SK", 2);
    map.put("Ram", 5);
    int val = map.get("Rohan");
    System.out.println(val);
    System.out.println(map.getOrDefault("Sohan", 76));

    System.out.println(map.containsKey("karan"));
    System.out.println(map.keySet());

    HashSet<Integer> set = new HashSet<>();
    set.add(3);
    set.add(2);
    set.add(7);
    set.add(13);
    set.add(22);
    set.add(17);
    set.add(33);
    set.add(254);
    set.add(734);
    set.add(322);
    set.add(223);
    set.add(71);

        System.out.println(set);

    }

}
