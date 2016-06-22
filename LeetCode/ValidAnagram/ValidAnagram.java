public class Solution {
    public boolean isAnagram(String s, String t) {
        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        String sortedS = new String(sArr);
        String sortedT = new String(tArr);
        
        return sortedS.equals(sortedT);
    }
}