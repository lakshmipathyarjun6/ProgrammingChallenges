    public int[] shortestToChar(String S, char C) {
        int [] distArr = new int[S.length()];
        Set<Integer> zeroIndices = new HashSet<Integer>();
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                distArr[i] = 0;
                zeroIndices.add(i);
            }
            else {
                distArr[i] = Integer.MAX_VALUE;
            }
        }
        
        for(Integer i : zeroIndices) {
            int leftSideCounter = 1;
            while(i-leftSideCounter >= 0 && S.charAt(i-leftSideCounter) != C) {
                distArr[i-leftSideCounter] = Math.min(leftSideCounter, distArr[i-leftSideCounter]);
                leftSideCounter++;
            }
            
            int rightSideCounter = 1;
            while(i+rightSideCounter < distArr.length && S.charAt(i+rightSideCounter) != C) {
                distArr[i+rightSideCounter] = Math.min(rightSideCounter, distArr[i+rightSideCounter]);
                rightSideCounter++;
            }
        }
        
        return distArr;
        
    }
}
