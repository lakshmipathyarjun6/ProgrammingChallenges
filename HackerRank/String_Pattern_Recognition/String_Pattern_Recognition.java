import java.io.*;
import java.util.*;

public class String_Pattern_Recognition {

    public static Hashtable<Character, String> table = new Hashtable<Character, String>();
    
    public static boolean patternMatch(String patternString, String queryString) {
        
        if(patternString.length() == 0 && queryString.length() == 0) {
            return true;
        }
        
        else if(patternString.length() > queryString.length() || patternString.length() == 0) {
            return false;
        }
        
        else {
            
            String value = table.get(patternString.charAt(0));
            
            if(value != null) { // we have this mapped to something already
                if(value.equals(queryString.substring(0, Math.min(value.length(),queryString.length())))) {
                    return patternMatch(patternString.substring(1), queryString.substring(value.length()));
                }
            }
            
            else { // unrecognized character - attempt to map it
                for (int i = 1; i <= queryString.length() - patternString.length() + 1;i++) {
                    if(!table.contains(queryString.substring(0,i))) {
                        table.put(patternString.charAt(0), queryString.substring(0,i));
                        
                        boolean newResult = patternMatch(patternString.substring(1), queryString.substring(i));
                        
                        if(newResult) {
                            System.out.println(table);
                            return true;
                        }
                        else {
                            table.remove(patternString.charAt(0));
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String patternString = "";
        String queryString = "";
        try {
            patternString = stdin.readLine();
            queryString = stdin.readLine();
            System.out.println(patternMatch(patternString, queryString));
            System.out.println(table);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }

}
