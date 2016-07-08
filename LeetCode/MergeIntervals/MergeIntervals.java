/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
 
        if(intervals==null || intervals.size()==0) {
            return result;
        }
 
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start!=i2.start) {
                    return i1.start-i2.start;
                }
                else {
                    return i1.end-i2.end;
                }
            }
        });
        
        result.add(intervals.get(0));
        int resultIndex = 0;
        
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= result.get(resultIndex).end) {
                result.get(resultIndex).end = Math.max(intervals.get(i).end,result.get(resultIndex).end);
            }
            else {
                result.add(intervals.get(i));
                resultIndex++;
            }
        }
        
        return result;
    }
}
