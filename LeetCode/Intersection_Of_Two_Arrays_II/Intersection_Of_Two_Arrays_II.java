public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> intersection = new ArrayList<Integer>();
        int num1Index = 0;
        int num2Index = 0;
        
        while(num1Index < nums1.length && num2Index < nums2.length) {
            if(nums1[num1Index] == nums2[num2Index]) {
                intersection.add(nums1[num1Index]);
                num1Index++;
                num2Index++;
            }
            else if(nums1[num1Index] < nums2[num2Index]) {
                num1Index++;
            }
            else {
                num2Index++;
            }
        }
        
        int [] result = new int[intersection.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = intersection.get(i);
        }
        
        return result;
    }
}
