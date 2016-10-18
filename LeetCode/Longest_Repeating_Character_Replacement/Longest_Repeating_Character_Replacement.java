public class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int windowStartIndex = 0;
        int windowEndIndex = 0;
        int maxWindowLen = 0;
        
        Character currentChar = null;
        
        while(windowStartIndex < s.length()) {
           currentChar = s.charAt(windowStartIndex); 
           int replacementsLeft = k;
           int currentWindowLen = 0;
           Integer firstDiscrepencyIndex = null;
           
           while(windowEndIndex < s.length() && (replacementsLeft > 0 || s.charAt(windowEndIndex) == currentChar)) {
               currentWindowLen = windowEndIndex - windowStartIndex + 1;
               if(s.charAt(windowEndIndex) != currentChar) {
                   if(firstDiscrepencyIndex == null) {
                       firstDiscrepencyIndex = windowEndIndex;
                   }
                   replacementsLeft--;
               }
               windowEndIndex++;
           }
           
           maxWindowLen = Math.max(maxWindowLen, currentWindowLen + replacementsLeft);
           
           if(windowEndIndex == s.length()) {
               break;
           }
           
           windowStartIndex = (firstDiscrepencyIndex != null) ? firstDiscrepencyIndex : windowEndIndex;
           windowEndIndex = windowStartIndex;
        }
        
        return Math.min(maxWindowLen, s.length());
    }
}
