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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newList = new LinkedList<Interval>();
        if(intervals.size() == 0) {
            newList.add(newInterval);
            return newList;
        }
        else if(newInterval.start > intervals.get(intervals.size()-1).end) {
            newList.addAll(intervals);
            newList.add(newInterval);
            return newList;
        }
        else if(newInterval.end < intervals.get(0).start) {
            newList.add(newInterval);
            newList.addAll(intervals);
            return newList;
        }
        
        int startIndex = 0;
        int endIndex = 0;
        
        boolean startIndexFound = false;
        boolean endIndexFound = false;
        
        if(newInterval.start < intervals.get(0).start) {
            startIndex = -1;
            startIndexFound = true;
        }
        
        for(int i = 0; i < intervals.size(); i++) {
            if(!startIndexFound && newInterval.start <= intervals.get(i).end) {
                startIndex = i;
                startIndexFound = true;
            }
            if(startIndexFound && newInterval.end < intervals.get(i).start) {
                endIndex = i-1;
                endIndexFound = true;
            }
            else if(startIndexFound && newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end) {
                endIndex = i;
                endIndexFound = true;
            }
            if(startIndexFound && endIndexFound) {
                break;
            }
        }
        
        if(!endIndexFound) {
            endIndex = intervals.size();
            endIndexFound = true;
        }
        
        if(startIndex == endIndex) {
            intervals.get(startIndex).start = Math.min(intervals.get(startIndex).start,newInterval.start);
            intervals.get(endIndex).end = Math.max(intervals.get(endIndex).end,newInterval.end);
            return intervals;
        }
        else if(startIndex > endIndex) {
            int index = 0;
            while(index < startIndex) {
                newList.add(intervals.get(index));
                index++;
            }
            Interval consolidated = new Interval();
            consolidated.start = newInterval.start;
            consolidated.end = newInterval.end;
            newList.add(consolidated);
            while(index < intervals.size()) {
                newList.add(intervals.get(index));
                index++;
            }
            return newList;
        }
        
        int index = 0;
        while(index < startIndex) {
            newList.add(intervals.get(index));
            index++;
        }
        
        Interval consolidated = new Interval();
        if(startIndex == -1) {
            consolidated.start = newInterval.start;
        }
        else {
            consolidated.start = Math.min(intervals.get(index).start,newInterval.start);
        }
        
        if(endIndex == intervals.size()) {
            consolidated.end = newInterval.end;
            newList.add(consolidated);
            return newList;
        }
        else {
            while(index < endIndex) {
                index++;
            }
        }
        
        consolidated.end = Math.max(intervals.get(index).end,newInterval.end);
        newList.add(consolidated);
        index++;
        while(index < intervals.size()) {
            newList.add(intervals.get(index));
            index++;
        }
        
        return newList;
    }
}
