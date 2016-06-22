import java.io.*;
import java.util.*;

public class UtopianTree {
    
    public static Integer computeHeight(int cycles) {
        
        int height = 1;
        boolean odd = true;
        while(cycles > 0) {
            if(odd) {
                height*=2;
                odd = false;
            }
            else {
                height++;
                odd = true;
            }
            cycles--;
        }
        return height;
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
                Integer cycles = Integer.parseInt(temp);
                nums.add(computeHeight(cycles));
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