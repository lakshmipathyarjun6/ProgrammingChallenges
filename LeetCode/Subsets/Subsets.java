public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) {
            return null;
        }
        
        Arrays.sort(nums);
        
        Set<List<Integer>> masterList = new HashSet<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        masterList.add(empty);
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(masterList);
            List<List<Integer>> temp = new ArrayList<List<Integer>>();

            for (List<Integer> a : masterList) {
                temp.add(new ArrayList<Integer>(a));
            }
    
            for (List<Integer> a : temp) {
                a.add(nums[i]);
            }
            
            temp.add(new ArrayList<Integer>());
            
            masterList.addAll(temp);
            
        }
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.addAll(masterList);
        return ret;
    }
}
