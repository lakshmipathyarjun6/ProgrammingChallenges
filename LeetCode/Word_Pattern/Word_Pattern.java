public class Solution {
    
    private boolean wordPatternHelper(String pattern, String [] words) {
        
        if(pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> table = new HashMap<Character, String>();
        
        for (int i = 0; i < pattern.length();i++) {
            
            String value = table.get(pattern.charAt(i));
            
            if(value != null) { // we have this mapped to something already
                if(!value.equals(words[i])) {
                    return false;
                }
                continue;
            }
            
            if(table.containsValue(words[i])) {
                return false;
            }
            else { // unrecognized character and word - map them
                table.put(pattern.charAt(i), words[i]);
            }
            
        }
        
        return true;
    }
    
    public boolean wordPattern(String pattern, String str) {
        String [] words = str.split("\\s+");
        return wordPatternHelper(pattern,words);
    }
    
}