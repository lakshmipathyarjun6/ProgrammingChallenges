public class Solution {
    public String shortestPalindrome(String s) {
        int head = 0;
        int tail = s.length()-1;
        
        while(tail >= 0) {
            if(s.charAt(head) == s.charAt(tail)) {
                head++;
            }
            tail--;
        }
        
        if(head == s.length()) {
            return s;
        }
        
        String suffix = s.substring(head);
        String prefix = new StringBuffer(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, head));
        return prefix+mid+suffix;
    }
}
