class Solution {
    public int hIndex(int[] citations) {
        int N = citations.length;

        int hIndex = -1;
        for(int i = 0; i < citations.length; i++) {
            int val = citations[i];
            int possibleHCandidate = N - i;
            if(val >= possibleHCandidate) {
                hIndex = possibleHCandidate;
                break;
            }
        }

        if(hIndex == -1) {
            hIndex = 0;
        }

        return hIndex;
    }
}
