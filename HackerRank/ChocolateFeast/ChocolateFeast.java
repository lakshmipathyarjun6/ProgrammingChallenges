import java.io.*;
import java.util.*;

public class ChocolateFeast {
    
    public static Integer computeTotal(int n, int c, int m) {
        
        int chocolates = 0;
        int wrappers = 0;
        while((n-c)>= 0) {
            chocolates++;
            wrappers++;
            n -= c;
        }
        while((wrappers-m) >= 0) {
            chocolates++;
            wrappers++;
            wrappers -= m;
        }
        return chocolates;
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (int i = 0; i < numLines; i++) {
                String temp = stdin.readLine();
                String [] splitarr = temp.split("\\s+");
                Integer N = Integer.parseInt(splitarr[0]);
                Integer C = Integer.parseInt(splitarr[1]);
                Integer M = Integer.parseInt(splitarr[2]);
                nums.add(computeTotal(N,C,M));
            }
            for (int i = 0; i < nums.size(); i++) {
                System.out.println(nums.get(i));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}