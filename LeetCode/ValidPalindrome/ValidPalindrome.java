public class Solution {
    public boolean isPalindrome(String s) {
        String newS = s.toLowerCase().replaceAll("\\s+","").replaceAll("[^A-Za-z0-9 ]", "");
        System.out.println(newS);
        for(int i = 0; i < newS.length()/2; i++) {
            if(newS.charAt(i) != newS.charAt(newS.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
