public class Solution {
    public String convertToTitle(int n) {
        String result = "";
 
        while(n > 0) {
            n--;
            Character ch = (char) (n % 26 + 'A');
            n /= 26;
            result = ch.toString() + result;
        }
        
        return result;
    }
}
