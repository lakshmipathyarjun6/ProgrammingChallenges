import java.io.*;
import java.util.*;

public class TwoArrays {
    
    public static boolean sumKCheck(ArrayList<ArrayList<Integer>> abset, int target) {
        ArrayList<Integer> a = abset.get(0);
        ArrayList<Integer> b = abset.get(1);
        if(a.size() != b.size()) {
            return false;
        }
        int length = a.size();
        for(int i = 0; i < length; i++) {
            int aval = a.get(i);
            int bval = b.get(i);
            if((aval+bval) < target) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            ArrayList<Boolean> results = new ArrayList<Boolean>(numLines);
            for (int i = 0; i < numLines; i++) {
                String temp = stdin.readLine();
                String [] splitarr = temp.split("\\s+");
                int numElems = Integer.parseInt(splitarr[0]);
                int target = Integer.parseInt(splitarr[1]);
                ArrayList<ArrayList<Integer>> abset = new ArrayList<ArrayList<Integer>>(2);
                ArrayList<Integer> a = new ArrayList<Integer>(numElems);
                ArrayList<Integer> b = new ArrayList<Integer>(numElems);
                for(int j = 0; j < 2; j++) {
                    temp = stdin.readLine();
                    String [] splits = temp.split("\\s+");
                    if(j == 0) {
                        for(int k = 0; k < numElems; k++) {
                            a.add(Integer.parseInt(splits[k]));
                        }
                    }
                    else {
                        for(int k = 0; k < numElems; k++) {
                            b.add(Integer.parseInt(splits[k]));
                        }
                    }
                }
                Collections.sort(a);
                Collections.sort(b,Collections.reverseOrder());
                abset.add(a);
                abset.add(b);
                results.add(sumKCheck(abset,target));
            }
            for (int i = 0; i < numLines; i++) {
                if(results.get(i)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}