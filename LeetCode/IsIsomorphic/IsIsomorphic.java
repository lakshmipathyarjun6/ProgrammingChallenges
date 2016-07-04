public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character,Character> stMap = new HashMap<Character,Character>();
        HashMap<Character,Character> tsMap = new HashMap<Character,Character>();
        
        for(int i = 0; i < s.length(); i++) {
            stMap.put(s.charAt(i),null);
        }
        for(int i = 0; i < t.length(); i++) {
            tsMap.put(t.charAt(i),null);
        }
        
        for(int i = 0; i < t.length(); i++) {
            if(stMap.get(s.charAt(i)) == null && tsMap.get(t.charAt(i)) == null) {
                stMap.put(s.charAt(i),t.charAt(i));
                tsMap.put(t.charAt(i),s.charAt(i));
            }
            else {
                Character stmapping = stMap.get(s.charAt(i));
                Character tsmapping = tsMap.get(t.charAt(i));
                if(stmapping == null || tsmapping == null || stmapping != t.charAt(i) || tsmapping != s.charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
