import java.io.*;
import java.util.*;

public class TwoStrings {
    
    public static boolean substringCheck(String s1, String s2) {
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i < s1.length(); i++) {
            hs.add(s1.charAt(i));
        }
        for(int i = 0; i < s2.length(); i++) {
            if(hs.contains(s2.charAt(i))) {
                return true;
            }
        }
        return false;
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
                String s1 = stdin.readLine();
                String s2 = stdin.readLine();
                results.add(substringCheck(s1,s2));
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