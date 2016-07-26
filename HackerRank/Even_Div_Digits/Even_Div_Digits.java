import java.io.*;
import java.util.*;

public class Even_Div_Digits {
    
    public static int findNumDivisors(Integer val) {
        int sum = 0;
        int currnum = val;
        int dig = 0;
        while(currnum > 0) {
            dig = currnum % 10;
            if(dig == 0) {
                currnum /= 10;
                continue;
            }
            else {
                int remainder = val % dig;
                if(remainder == 0) {
                    sum += 1;
                }
                currnum /= 10;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            ArrayList<Integer> nums = new ArrayList<Integer>(numLines);
            for (int i = 0; i < numLines; i++) {
                String temp = stdin.readLine();
                nums.add(Integer.parseInt(temp));
            }
            for (int i = 0; i < numLines; i++) {
                int result = findNumDivisors(nums.get(i));
                System.out.println(result);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
