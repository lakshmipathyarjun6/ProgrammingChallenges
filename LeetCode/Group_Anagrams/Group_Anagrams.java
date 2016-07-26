public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
 
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
 
            if(map.containsKey(ns)) {
                map.get(ns).add(str);
            }
            else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }
 
        result.addAll(map.values());
 
        return result;
    }
}
