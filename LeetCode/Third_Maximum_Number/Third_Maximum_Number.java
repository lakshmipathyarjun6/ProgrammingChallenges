public class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        
        for(Integer val : nums) {
            if(val.equals(max) || val.equals(secondMax) || val.equals(thirdMax)) {
                continue;
            }
            if(max == null || val > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = val;
            }
            else if(secondMax == null || val > secondMax) {
                thirdMax = secondMax;
                secondMax = val;
            }
            else if(thirdMax == null || val > thirdMax) {
                thirdMax = val;
            }
        }
        
        return (thirdMax != null) ? thirdMax : max;
    }
}
