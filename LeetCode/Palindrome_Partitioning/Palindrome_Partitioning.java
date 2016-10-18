public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new LinkedList<List<String>>();
        
        if(s == null || s.length() == 0) {
            return results;
        }
        
        List<String> partition = new ArrayList<String>();
        addPalindrome(s, 0, partition, results);
        
        return results;
    }
    
    private void addPalindrome(String s, int start, List<String> partition, List<List<String>> results) {
        if (start == s.length()) {
            List<String> temp = new ArrayList<String>(partition);
            results.add(temp);
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str); 
                addPalindrome(s, i, partition, results);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
