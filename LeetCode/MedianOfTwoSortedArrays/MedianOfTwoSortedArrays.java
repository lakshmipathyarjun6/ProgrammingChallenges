public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while(k >= 0) {
            if(j < 0) {
                return;
            }
            else if(i < 0) {
                nums1[k] = nums2[j];
                j--;
            }
            else {
                if(nums2[j] > nums1[i]) {
                    nums1[k] = nums2[j];
                    j--;
                }
                else {
                    nums1[k] = nums1[i];
                    i--;
                }
            }
            k--;
        }
        
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] finalArr = new int[nums1.length + nums2.length];
        
        for(int i = 0; i < nums1.length; i++) {
            finalArr[i] = nums1[i];
        }
        
        merge(finalArr,nums1.length,nums2,nums2.length);
        
        int head = 0;
        int tail = finalArr.length-1;
        
        while(tail > head) {
            head++;
            tail--;
        }
        
        double headRet = finalArr[head];
        double tailRet = finalArr[tail];
        
        return (head == tail) ? headRet : (headRet + tailRet) / 2;
    }
}