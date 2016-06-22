import java.io.*;
import java.util.*;

public class AngryProfessor {
    
    public static String classInSession(int n, int k, ArrayList<Integer> times) {
        
        int counter = 0;
        for(int i = 0; i < n; i++) {
            if(times.get(i) <= 0) // increment every time a student comes on time
                counter++;
            if(counter >= k)
                return "NO";
        }
        return "YES";
        
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            ArrayList<String> cases = new ArrayList<String>();
            for (int i = 0; i < numLines; i++) {
                String temp = stdin.readLine();
                String [] splitarr = temp.split("\\s+");
                Integer students = Integer.parseInt(splitarr[0]);
                Integer min_num = Integer.parseInt(splitarr[1]);
                temp = stdin.readLine();
                String [] splitarr2 = temp.split("\\s+");
                ArrayList<Integer> times = new ArrayList<Integer>();
                for(int j = 0; j < splitarr2.length; j++) {
                    times.add(Integer.parseInt(splitarr2[j]));
                }
                cases.add(classInSession(students,min_num,times));
            }
            for (int i = 0; i < cases.size(); i++) {
                System.out.println(cases.get(i));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
