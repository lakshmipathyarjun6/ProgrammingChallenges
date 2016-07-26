public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0) {
            return 0;
        }
 
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
 
        int [] indices = new int[primes.length];
        for(int i = 0; i < indices.length; i++) {
            indices[i] = 0;
        }
        
        while(list.size() < n){
            List<Integer> candidates = new ArrayList<Integer>();
            for(int i = 0; i < indices.length; i++) {
                candidates.add(list.get(indices[i])*primes[i]);
            }
 
            int min = Integer.MAX_VALUE;
            int candidateIndex = -1;
            for(int i = 0; i < candidates.size(); i++) {
                if(candidates.get(i) < min) {
                    min = candidates.get(i);
                    candidateIndex = i;
                }
            }
            if(list.get(list.size()-1) != min) { // do not allow duplicates
                list.add(min);
            }
 
            indices[candidateIndex]++;
        }
 
        return list.get(list.size()-1);
    }
}
