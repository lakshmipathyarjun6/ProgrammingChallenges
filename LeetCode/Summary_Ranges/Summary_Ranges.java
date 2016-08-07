public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<Range> intermediate = new LinkedList<Range>();
        if(nums == null || nums.length == 0) {
            List<String> result = new LinkedList<String>();
            return result;
        }
        Range first = new Range();
        first.start = nums[0];
        intermediate.add(first);
        for(int i = 1; i < nums.length; i++) {
            Range previous = intermediate.get(intermediate.size()-1);
            if(previous.end != null) {
                if(nums[i] == previous.end+1) {
                    previous.end = nums[i];
                }
                else {
                    Range newRange = new Range();
                    newRange.start = nums[i];
                    intermediate.add(newRange);
                }
            }
            else {
                if(nums[i] == previous.start+1) {
                    previous.end = nums[i];
                }
                else {
                    previous.end = previous.start;
                    Range newRange = new Range();
                    newRange.start = nums[i];
                    intermediate.add(newRange);
                }
            }
        }
        if(intermediate.get(intermediate.size()-1).end == null) {
            intermediate.get(intermediate.size()-1).end = intermediate.get(intermediate.size()-1).start;
        }
        List<String> result = new LinkedList<String>();
        for(Range range : intermediate) {
            result.add(range.toString());
        }
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
        if(start == end) {
            return String.valueOf(start);
        }
        return String.valueOf(start) + "->" + String.valueOf(end);
    }
}



