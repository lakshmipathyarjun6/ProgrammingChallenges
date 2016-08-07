public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<String>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Range current = new Range();
        current.start = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int comparisonVal = (current.end != null) ? current.end+1 : current.start+1;
            if(nums[i] == comparisonVal) {
                current.end = nums[i];
            }
            else {
                result.add(current.toString());
                current = new Range();
                current.start = nums[i];
            }
        }
        result.add(current.toString());
        return result;
    }
}

class Range {
    Integer start;
    Integer end;
    public Range() {
        start = null;
        end = null;
    }
    public String toString() {
        if(end == null) {
            return String.valueOf(start);
        }
        return String.valueOf(start) + "->" + String.valueOf(end);
    }
}

