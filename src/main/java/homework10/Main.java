package homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Map<List<Set<Integer>>, String>> list = new ArrayList<Map<List<Set<Integer>>, String>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(5);
        set.add(6);

        List<Set<Integer>> setList = new ArrayList<Set<Integer>>();
        setList.add(set);

        Map<List<Set<Integer>>, String> map = new HashMap<List<Set<Integer>>, String>();
        map.put(setList, "Slava");
        map.put(setList, "Cheban");

        list.add(map);
        UtilXML.wrightListToXML(list);
    }

}
