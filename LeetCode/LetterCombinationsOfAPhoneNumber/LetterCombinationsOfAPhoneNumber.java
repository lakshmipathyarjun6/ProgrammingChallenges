public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
 
        List<String> result = new ArrayList<String>();
 
        if(digits == null || digits.length() == 0) {
            return result;
        }
 
        List<Character> temp = new ArrayList<Character>();
        getString(digits, temp, result, map);
 
        return result;
    }
    
    public void getString(String digits, List<Character> temp, List<String> result,  Map<Integer, String> map) {
        if(digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for(int i=0; i<temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            result.add(String.valueOf(arr));
            return;
        }
 
        Integer curr = Integer.valueOf(digits.substring(0,1));
        String letters = map.get(curr);
        for(int i=0; i<letters.length(); i++) {
            temp.add(letters.charAt(i));
            getString(digits.substring(1), temp, result, map);
            temp.remove(temp.size()-1);
        }
    }
}
