public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            return ret;
        }
        
        List<Set<List<Integer>>> results = new LinkedList<Set<List<Integer>>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        set.add(list);
        results.add(0,set);
        
        for(int i = 1; i < nums.length; i++) {
            Set<List<Integer>> prevSet = results.get(i-1);
            Set<List<Integer>> newSet = new HashSet<List<Integer>>();
            for(List<Integer> ls : prevSet) {
                List<Integer> perm = new ArrayList<Integer>(ls);
                perm.add(nums[i]);
                newSet.add(perm);
                for(int k = 0; k < ls.size(); k++) {
                    perm = new ArrayList<Integer>(ls);
                    perm.add(k,nums[i]);
                    newSet.add(perm);
                }
            }
            results.add(newSet);
        }
        
        List<List<Integer>> finalSet = new ArrayList<List<Integer>>();
        finalSet.addAll(results.get(results.size()-1));
        
        return finalSet;
    }
}
