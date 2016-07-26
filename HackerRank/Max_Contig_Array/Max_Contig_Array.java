import java.io.*;
import java.util.*;

public class Max_Contig_Array {
    
    public static int findMaxContig(ArrayList<Integer> arr) {
        int sumQuants [] = new int[arr.size()];
        int maxSums [] = new int[arr.size()];
        maxSums[0] = Math.max(0,arr.get(0));
        sumQuants[0] = Math.max(0,arr.get(0));
        for(int i = 1; i < maxSums.length; i++) {
            int prevMax = maxSums[i-1];
            int currentVal = arr.get(i);
            sumQuants[i] = Math.max(sumQuants[i-1]+currentVal,0);
            maxSums[i] = Math.max(prevMax,sumQuants[i]);
        }
        return maxSums[maxSums.length-1];
    }
    
    public static int findMaxNonContig(ArrayList<Integer> arr) {
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            if(val > 0) {
                sum += val;
            }
        }
        return sum;
    }
    
    public static int arrayPreCheck(ArrayList<Integer> arr,int whichCase) {
        int maxNeg = -1000000;
        boolean flag = false;
        for(int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            if(val > 0) {
                flag = true;
                break;
            }
            else if(val > maxNeg) {
                maxNeg = val;
            }
        }
        if(flag) {
            if(whichCase == 1) {
                return findMaxContig(arr);
            }
            else {
                return findMaxNonContig(arr);
            }
        }
        return maxNeg;
    }

    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.flush();
        String submittedString = ""; 
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>(numLines);
            for (int i = 0; i < numLines; i++) {
               stdin.readLine();
               String temp = stdin.readLine();
               String [] splitarr = temp.split("\\s+");
               ArrayList<Integer> ind = new ArrayList<Integer>();
               for(int j = 0; j < splitarr.length; j++) {
                    ind.add(Integer.parseInt(splitarr[j]));
               }
               group.add(ind);
            }
            for (int i = 0; i < numLines; i++) {
                int contigResult = arrayPreCheck(group.get(i),1);
                int nonContigResult = arrayPreCheck(group.get(i),2);
                System.out.println(contigResult + " " + nonContigResult);
            } 
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
