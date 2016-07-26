public class Solution {
    public boolean isPalindrome(int x) {
        String val = Integer.toString(x);
        for(int i = 0; i < val.length()/2; i++) {
            if(val.charAt(i) != val.charAt(val.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}