public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] range = new int[2];
        range[0]=-1;
        range[1]=-1;
 
        binarySearch(nums, 0, nums.length-1, target, range);
        return range;
    }
    
    public void binarySearch(int[] nums, int left, int right, int target, int[] arr) {
        if(right < left) {
            return;
        }
 
        if(nums[left] == nums[right] && nums[left] == target){
            arr[0] = left;
            arr[1] = right;
            return;
        }
 
        int mid = left + (right-left) / 2;
          
        if(nums[mid] < target) {
            binarySearch(nums, mid + 1, right, target, arr);
        }
        else if(nums[mid] > target) {
            binarySearch(nums, left, mid-1, target, arr);
        }
        else{
            arr[0]=mid;
            arr[1]=mid;
 
            //handle duplicates - left
            int t1 = mid;
            while(t1 > left && nums[t1] == nums[t1 - 1]) {
                t1--;
                arr[0] = t1;
            }
 
            //handle duplicates - right
            int t2 = mid;
            while(t2 < right && nums[t2] == nums[t2 + 1]){
                t2++;
                arr[1] = t2;
            }
            return;
        }
   }
}
