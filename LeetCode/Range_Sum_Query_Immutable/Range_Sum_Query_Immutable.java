public class NumArray {
    
    private int [] numArr;
    
    public NumArray(int[] nums) {
        if(nums.length > 0) {
            numArr = new int[nums.length];
            numArr[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                numArr[i] = numArr[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        int retVal = (i-1 >= 0) ? (numArr[j] - numArr[i-1]) : numArr[j];
        return retVal;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);