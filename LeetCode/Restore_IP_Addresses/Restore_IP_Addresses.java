public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> partition = new ArrayList<String>();
        dfs(result, s, 0, partition);
 
        List<String> finalResult = new ArrayList<String>();
 
        for(List<String> l : result){
            String restoredAddress = "";
            for(String str : l){
                restoredAddress += str + ".";
            }
            finalResult.add(restoredAddress.substring(0,restoredAddress.length()-1));
        }
 
        return finalResult;
    }
    
    private void dfs(List<List<String>> result, String s, int start, List<String> partition) {
        if(partition.size() >= 4 && start != s.length()) {
            return;
        }

        if((partition.size() + s.length() - start + 1) < 4) {
            return;
        }
 
        if(partition.size() == 4 && start == s.length()){
            List<String> possible = new ArrayList<String>(partition);
            result.add(possible);
            return;
        }
 
        for(int i = 1; i <= 3; i++) {
            if(start + i > s.length()) {
                break;
            }
 
            String sub = s.substring(start, start+i);
            if(i > 1 && s.charAt(start) == '0') {
                break;    
            }
 
            if(Integer.valueOf(sub) > 255) {
                break;
            }
 
            partition.add(sub);
            dfs(result, s, start + i, partition);
            partition.remove(partition.size() - 1);
        }
    }
}
