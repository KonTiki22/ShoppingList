package com.company;

import java.util.*;

public class ShoppingList {

    HashMap<String, HashMap<String, Integer>> Slist = new  HashMap<>();

    public void add(String record) throws Exception {
        String[] rec = record.split(" ");
        if (rec.length != 3) throw new Exception("Invalid recording format");
        if (!Slist.containsKey(rec[0])) {
            Slist.put(rec[0], new HashMap(Map.of(rec[1], Integer.parseInt(rec[2]))));
        }
        else{
            HashMap<String, Integer> innerMap = Slist.get(rec[0]);
            Integer value = innerMap.containsKey(rec[1])? innerMap.get(rec[1]) : 0;
            innerMap.put(rec[1], value + Integer.parseInt(rec[2]));
        }
    }

    @Override
    public String toString() {
        ArrayList<String> output = new ArrayList();

        for(String key : new TreeSet<String>(Slist.keySet())) {
            output.add(key + ":");
            SortedMap<String, Integer> innerMap = new TreeMap<>(Slist.get(key));
            for(Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                output.add(entry.getKey() + " " + entry.getValue());
            }
        }
        return String.join("\n", output);
    }
}
