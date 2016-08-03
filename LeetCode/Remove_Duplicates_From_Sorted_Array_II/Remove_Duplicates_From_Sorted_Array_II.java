public class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> occurrences = new HashMap<Integer,Integer>();
        List<Integer> resultVals = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            Integer freq = occurrences.get(nums[i]);
            if(freq == null) {
                occurrences.put(nums[i],1);
                resultVals.add(nums[i]);
            }
            else {
                freq++;
                if(freq <= 2) {
                    occurrences.put(nums[i],freq);
                    resultVals.add(nums[i]);
                }
            }
        }
        
        for(int i = 0; i < resultVals.size(); i++) {
            nums[i] = resultVals.get(i);
        }
        
        return resultVals.size();
    }
}
