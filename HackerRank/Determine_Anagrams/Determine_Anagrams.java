import java.io.*;
import java.util.*;

public class Determine_Anagrams {
    
    public static boolean allAnagrams (ArrayList <String> anagramList) {
        
        String referenceAnagram = anagramList.get(0);
        char[] referenceAnagramChars = referenceAnagram.toCharArray();
        Arrays.sort(referenceAnagramChars);
        String sortedReferenceAnagram = new String(referenceAnagramChars);
        
        for(int i = 1; i < anagramList.size(); i++) {
            String str = anagramList.get(i);
            char[] strCharArr = str.toCharArray();
            Arrays.sort(strCharArr);
            String sortedStr = new String(strCharArr);
            
            if(!sortedStr.equals(sortedReferenceAnagram)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        
        ArrayList<String> anagramList = new ArrayList<String>();
        
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            for (int i = 0; i < numLines; i++) {
                String word = stdin.readLine();
                anagramList.add(word);
            }
            System.out.println(allAnagrams(anagramList));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
