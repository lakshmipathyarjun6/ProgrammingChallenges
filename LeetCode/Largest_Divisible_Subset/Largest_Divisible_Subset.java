public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        List<List<Integer>> largestPossibleLists = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        result = first;
        largestPossibleLists.add(first);
        
        int largestIndex = 0;
        
        for(int i = 1; i < nums.length; i++) {
            List<Integer> toInsert = null;
            if(nums[i] % result.get(result.size()-1) == 0) {
                toInsert = new ArrayList<Integer>(result);
            }
            else {
                for(int j = i-1; j >= 0; j--) {
                    if(nums[i] % nums[j] == 0) {
                        toInsert = new ArrayList<Integer>(largestPossibleLists.get(j));
                        break;
                    }
                }
            }
            if(toInsert == null) {
                toInsert = new ArrayList<Integer>();
            }
            toInsert.add(nums[i]);
            largestPossibleLists.add(toInsert);
            result = (toInsert.size() > result.size()) ? toInsert : result;
        }
        return result;
    }
}
