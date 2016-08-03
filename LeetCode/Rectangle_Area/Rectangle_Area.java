public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1Area = (C-A)*(D-B);
        int rect2Area = (G-E)*(H-F);
        
        return rect1Area + rect2Area - computeIntersection(A,B,C,D,E,F,G,H);
    }
    
    private int computeIntersection(int A, int B, int C, int D, int E, int F, int G, int H) {
        int horizontalLength = 0;
        int verticalLength = 0;
        
        // no overlap
        if(E > C || A > G) { 
            return horizontalLength;
        }
        else if(B > H || F > D) { 
            return verticalLength;
        }
        
        horizontalLength = Math.min(C-E, Math.min(G-E, Math.min(C-A, G-A)));
        verticalLength = Math.min(H-B, Math.min(D-F, Math.min(H-F, D-B)));
        
        return horizontalLength*verticalLength;
    }
}
