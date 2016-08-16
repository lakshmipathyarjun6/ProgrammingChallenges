public class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tCharFrequency = new HashMap<Character,Integer>();
        int numCharsToFind = createFrequencyMap(t,tCharFrequency);
        
        Map<Character,Integer> sCharFrequency = new HashMap<Character,Integer>();
        int windowMin = 0;
        int windowMax = 0;
        int startIndex = 0;
        int endIndex = 0;
        
        // Find the first window, if one exists
        while(windowMax < s.length()) { 
            Character ch = s.charAt(windowMax);
            if(tCharFrequency.containsKey(ch)) {
                if(sCharFrequency.containsKey(ch)) {
                    sCharFrequency.put(ch,sCharFrequency.get(ch)+1);
                }
                else {
                    sCharFrequency.put(ch,1);
                }
                if(sCharFrequency.get(ch) <= tCharFrequency.get(ch)) {
                    numCharsToFind--;
                }
            }
            if(numCharsToFind == 0) {
                endIndex = windowMax;
                break;
            }
            windowMax++;
        }
        if(windowMax >= s.length()) {
            return ""; // no substring was found
        }
        while(numCharsToFind == 0) {
            Character ch = s.charAt(windowMin);
            if(tCharFrequency.containsKey(ch) && tCharFrequency.get(ch) < sCharFrequency.get(ch)) {
                sCharFrequency.put(ch,sCharFrequency.get(ch)-1); 
            }
            else if(tCharFrequency.containsKey(ch)) {
                numCharsToFind++;
            }
            windowMin++;
        }
        numCharsToFind--;
        startIndex = --windowMin;
        
        // Now find the smallest window
        while(windowMax < s.length()) {
            windowMax++;
            if(windowMax >= s.length()) {
                return s.substring(startIndex,endIndex+1);
            }
            while(s.charAt(windowMax) != s.charAt(windowMin)) {
                Character ch = s.charAt(windowMax);
                if(tCharFrequency.containsKey(ch)) {
                    sCharFrequency.put(ch,sCharFrequency.get(ch)+1);
                }
                windowMax++;
                if(windowMax >= s.length()) {
                    return s.substring(startIndex,endIndex+1);
                }
            }
            windowMin++;
            while(!tCharFrequency.containsKey(s.charAt(windowMin))  || tCharFrequency.get(s.charAt(windowMin)) < sCharFrequency.get(s.charAt(windowMin))) {
                if(tCharFrequency.containsKey(s.charAt(windowMin)) && tCharFrequency.get(s.charAt(windowMin)) < sCharFrequency.get(s.charAt(windowMin))) {
                    sCharFrequency.put(s.charAt(windowMin),sCharFrequency.get(s.charAt(windowMin))-1); 
                }
                else if(tCharFrequency.containsKey(s.charAt(windowMin))) {
                    break;
                }
                windowMin++;
            }
            if(windowMax - windowMin < endIndex - startIndex) {
                startIndex = windowMin;
                endIndex = windowMax;
            }
        }
        
        return s.substring(startIndex,endIndex+1);
    }
    
    private int createFrequencyMap(String t, Map<Character,Integer> retVal) {
        int totalChars = 0;
        for(int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if(retVal.containsKey(ch)) {
                retVal.put(ch,retVal.get(ch)+1);
            }
            else {
                retVal.put(ch,1);
            }
            totalChars++;
        }
        return totalChars;
    }
}
