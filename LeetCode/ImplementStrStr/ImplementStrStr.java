public class Solution {
    private boolean matchRemainder(String original, String target, int startOffset) {
        for(int i = 0; i < target.length(); i++) {
            if(startOffset+i >= original.length()) {
                return false;
            }
            else if(original.charAt(i+startOffset) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }
        else if(needle.equals("")) {
            return 0;
        }
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(matchRemainder(haystack,needle,i)) {
                    return i;
                }
            }
        }
        return -1;
    }
}