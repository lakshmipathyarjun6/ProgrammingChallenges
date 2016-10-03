public class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> freqCount = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(freqCount.containsKey(ch)) {
                freqCount.put(ch,freqCount.get(ch)+1);
            }
            else {
                freqCount.put(ch,1);
            }
        }
        
        int longestLength = 0;
        boolean plusOneFlag = false;
        for(Character ch : freqCount.keySet()) {
            Integer count = freqCount.get(ch);
            longestLength += (count / 2) * 2;
            if(count % 2 == 1) {
                plusOneFlag = true;
            }
        }
        
        return (plusOneFlag) ? longestLength+1 : longestLength;
    }
}
