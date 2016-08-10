public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> foundChars = new HashSet<Character>();
        int windowMin = 0;
        int windowMax = 0;
        int longestSubstringLength = 0;
        
        while(windowMax < s.length()) {
            if(windowMax == 0) {
                longestSubstringLength = 1;
            }
            else {
                while(foundChars.contains(s.charAt(windowMax))) {
                    foundChars.remove(s.charAt(windowMin));
                    windowMin++;
                }
                longestSubstringLength = Math.max(longestSubstringLength, windowMax-windowMin+1);
            }
            foundChars.add(s.charAt(windowMax));
            windowMax++;
        }
        
        return longestSubstringLength;
    }
}
