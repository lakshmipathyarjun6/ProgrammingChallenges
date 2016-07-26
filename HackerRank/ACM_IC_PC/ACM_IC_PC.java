import java.io.*;
import java.util.*;

public class ACM_IC_PC {
    
    public static void calculateOptimal(ArrayList<Integer[]> peoplesTopics) {
        
        int maxTotal = 0;
        int numTeamsWithMaxTotal = 0;
        
        for (int i = 0; i < peoplesTopics.size(); i++) {
            Integer [] PersonA = peoplesTopics.get(i);
            for (int j = i+1; j < peoplesTopics.size(); j++) {
                Integer [] PersonB = peoplesTopics.get(j);
                int total = 0;
                for (int k = 0; k < PersonA.length; k++) {
                    total += Math.max(PersonA[k],PersonB[k]);
                }
                if(total > maxTotal) {
                    numTeamsWithMaxTotal = 1;
                    maxTotal = total;
                }
                else if(total == maxTotal) {
                    numTeamsWithMaxTotal++;
                }
            }
        }
        
        System.out.println(maxTotal);
        System.out.println(numTeamsWithMaxTotal);
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer[]> peoplesTopics = new ArrayList<Integer[]>();
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            String [] splitarr = submittedString.split("\\s+");
            Integer numPeople = Integer.parseInt(splitarr[0]);
            Integer numTopics = Integer.parseInt(splitarr[1]);
            
            for (int i = 0; i < numPeople; i++) {
                String topicsKnown = stdin.readLine();
                Integer [] knowledge = new Integer[topicsKnown.length()];
                for(int j = 0; j < topicsKnown.length(); j++) {
                    knowledge[j] = Character.getNumericValue(topicsKnown.charAt(j));
                }
                peoplesTopics.add(knowledge);
            }
            
            calculateOptimal(peoplesTopics);
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
