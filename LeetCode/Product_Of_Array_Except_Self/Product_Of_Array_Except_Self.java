public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] output = new int[nums.length];
        for(int i = output.length-1; i >= 0; i--) {
            output[i] = (i+1 < output.length) ? nums[i]*output[i+1] : nums[i];
        }
        int leftProduct = 1;
        for(int i = 0; i < output.length; i++) {
            output[i] = (i+1 < output.length) ? leftProduct*output[i+1] : leftProduct;
            leftProduct *= nums[i];
        }
        return output;
    }
}
