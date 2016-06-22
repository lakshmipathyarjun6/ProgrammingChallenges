/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        
        int low = 1;
        int high = n;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            boolean evaluation = isBadVersion(mid);
            if((evaluation && mid - 1 < 1) || (evaluation && !isBadVersion(mid-1))) {
                return mid;
            }
            else if(evaluation) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
    
}