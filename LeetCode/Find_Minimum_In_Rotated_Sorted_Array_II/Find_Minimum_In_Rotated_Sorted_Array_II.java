public class Solution {
    public int findMin(int[] nums) {
        return findMin(nums,0,nums.length-1);
    }
    
    public int findMin(int[] num, int left, int right) {
        if(right == left) {
            return num[left];
        }
        if(right == left + 1) {
            return Math.min(num[left], num[right]);
        }
 
        int middle = (right-left)/2 + left;
        if(num[right] > num[left]) {
            return num[left];
        }
        else if(num[right] == num[left]) {
            return findMin(num, left+1, right);
        }
        else if(num[middle] >= num[left]) {
            return findMin(num, middle, right);
        }
        else{
            return findMin(num, left, middle);
        }
    }
}
