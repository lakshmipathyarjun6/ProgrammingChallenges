import java.io.*;
import java.util.*;

public class CutSticks {
    
    public static int findMin(ArrayList<Integer> list) {
        int min = 2000;
        for(int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if(current < min) {
                min = current;
            }
        }
        return  min;
    }
    
    public static ArrayList<Integer> cut(ArrayList<Integer> sticks) {
        
        ArrayList<Integer> cuts = new ArrayList<Integer>();
        int i = sticks.size();
        while(sticks.size() > 0) {
            cuts.add(sticks.size());
            int min = findMin(sticks);
            int j = 0;
            while(j < sticks.size()) {
                int current = sticks.get(j);
                if (current > min){
                    Integer newVal = current - min;
                    sticks.set(j,newVal);
                    j++;
                }
                else {
                    sticks.remove(j);
                }
            }
        }
        return cuts;
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            ArrayList<Integer> sticks = new ArrayList<Integer>();
            String temp = stdin.readLine();
            String [] splitarr = temp.split("\\s+");
            for (int i = 0; i < numLines; i++) {
                sticks.add(Integer.parseInt(splitarr[i]));
            }
            ArrayList<Integer> cutSticks = cut(sticks);
            for (int i = 0; i < cutSticks.size(); i++) {
                System.out.println(cutSticks.get(i));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}