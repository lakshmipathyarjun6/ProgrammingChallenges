public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1]) {
            return nums.length;
        }
        else if(target < nums[0]) {
            return 0;
        }
        
        int lower = 0;
        int upper = nums.length;
        int mid = 0;
        
        while(lower <= upper) {
            mid = lower + (upper - lower) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                lower = mid + 1;
            }
            else {
                upper = mid - 1;
            }
        }
        
        return (target < nums[mid]) ? mid : mid+1;
    }
}
