public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null) {
            return null;
        }
        
        Arrays.sort(nums);
        
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> temp = new HashSet<List<Integer>>();
 
            //get sets that are already in result
            for (List<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }
            
            //add S[i] to existing sets
            for (List<Integer> a : temp) {
                a.add(nums[i]);
            }
 
            //add S[i] only as a set
            List<Integer> single = new ArrayList<Integer>();
            single.add(nums[i]);
            temp.add(single);
 
            result.addAll(temp);
        }
        
        List<Integer> emptyList = new ArrayList<Integer>();
        result.add(emptyList);
 
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
        finalResult.addAll(result);
 
        return finalResult;
    }
}
