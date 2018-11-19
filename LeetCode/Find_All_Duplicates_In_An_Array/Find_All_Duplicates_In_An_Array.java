class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> original = new HashSet<Integer>();
        Set<Integer> found = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];
            original.add(value);
            if(found.contains(value)) {
                found.remove(value);
            }
            else {
                found.add(value);
            }
        }
        original.removeAll(found);
        List<Integer> toReturn = new ArrayList<Integer>(original);
        return toReturn;
    }
}
