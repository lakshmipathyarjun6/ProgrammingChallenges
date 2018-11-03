import java.util.regex.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeatedSequences = new HashSet<String>();
        Set<String> candidateRepeatedSequences = new HashSet<String>();
        for(int i = 0; i < s.length(); i++) {
            if(i + 10 <= s.length()) {
                String candidateSequence = s.substring(i,i+10);
                if(candidateRepeatedSequences.contains(candidateSequence)) {
                    repeatedSequences.add(candidateSequence);
                    candidateRepeatedSequences.remove(candidateSequence);
                }
                else {
                    candidateRepeatedSequences.add(candidateSequence);
                }
                
            }
            else {
                break; // cannot possibly find any more matches
            }
        }
        
        return new ArrayList<String>(repeatedSequences);
    }
}
