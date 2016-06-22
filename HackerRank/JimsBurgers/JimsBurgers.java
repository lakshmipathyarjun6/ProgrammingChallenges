import java.io.*;
import java.util.*;

public class JimsBurgers {
    
    public static TreeMap<Integer,Integer> SortByValue(HashMap<Integer,Integer> map) {
        ValueComparator vc =  new ValueComparator(map);
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(vc);
        sortedMap.putAll(map);
        return sortedMap;
    }
    
    public static ArrayList<Integer> sortCustomers(HashMap<Integer,Integer> orders) {
        
        ArrayList<Integer> sortedCustomers = new ArrayList<Integer>();
        TreeMap<Integer,Integer> sortedOrders = SortByValue(orders);
        for(Map.Entry<Integer,Integer> entry : sortedOrders.entrySet()) {
            sortedCustomers.add(entry.getKey());
        }
        return sortedCustomers;
        
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            HashMap<Integer,Integer> orders = new HashMap<Integer,Integer>();
            for (int i = 0; i < numLines; i++) {
                String temp = stdin.readLine();
                String [] splitarr = temp.split("\\s+");
                Integer ordertime = Integer.parseInt(splitarr[0]);
                Integer orderlength = Integer.parseInt(splitarr[1]);
                orders.put(i+1,ordertime+orderlength);
            }
            ArrayList<Integer> sortedCustomers = sortCustomers(orders);
            for (int i = 0; i < sortedCustomers.size(); i++) {
                System.out.print(sortedCustomers.get(i));
                if(i < (sortedCustomers.size()-1)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}

class ValueComparator implements Comparator<Integer> {
    
    Map<Integer,Integer> map;
    
    public ValueComparator(Map<Integer,Integer> base) {
        this.map = base;
    }
    
    public int compare(Integer a, Integer b) {
        if (map.get(a) < map.get(b)) {
            return -1;
        }
        else {
            return 1;
        }
    }
}