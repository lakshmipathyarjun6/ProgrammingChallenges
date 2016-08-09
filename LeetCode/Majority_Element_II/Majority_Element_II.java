public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        // Step 1: Identify the majority elements, if any
        List<Integer> candidateList = generateCandidateList(nums);
 
        // Step 2: Get the counts of the majority elements
        List<Integer> elementCounts = majorityElementCounts(candidateList,nums);
        
        // Step 3: See if their counts are greater than the thresholds
        if(elementCounts.get(0) > nums.length/3) { 
            result.add(candidateList.get(0));
        }
        if(elementCounts.get(1) > nums.length/3) {
            result.add(candidateList.get(1));
        }
        
        return result;
    }
    
    private List<Integer> generateCandidateList(int [] nums) {
        Integer majElem1 = null;
        Integer majElem2 = null;
        int countMajElem1=0; 
        int countMajElem2=0;
        for(int i = 0; i < nums.length; i++) { 
            if(majElem1 != null && nums[i] == majElem1) {
                countMajElem1++;
            }
            else if(majElem2 != null && nums[i] == majElem2) {
                countMajElem2++;
            }
            else if(countMajElem1 == 0) {
                countMajElem1=1;
                majElem1 = nums[i];
            }
            else if(countMajElem2 == 0) {
                countMajElem2=1;
                majElem2 = nums[i];
            }
            else {
                countMajElem1--;
                countMajElem2--;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(majElem1);
        result.add(majElem2);
        return result;
    }
    
    private List<Integer> majorityElementCounts(List<Integer> candidateList, int [] nums) {
        Integer majElem1 = candidateList.get(0);
        Integer majElem2 = candidateList.get(1);
        int countMajElem1=0; 
        int countMajElem2=0;
        for(int i = 0; i < nums.length; i++){ 
            if(nums[i] == majElem1) {
                countMajElem1++;
            }
            else if(nums[i] == majElem2){
                countMajElem2++;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(countMajElem1);
        result.add(countMajElem2);
        return result;
    }
}
