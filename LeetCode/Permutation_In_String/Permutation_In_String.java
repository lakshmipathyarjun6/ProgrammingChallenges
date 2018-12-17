class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> freqList = new HashMap<Character,Integer>();
        
        for(char c : s1.toCharArray()) {
            if(freqList.containsKey(c)) {
                freqList.put(c,freqList.get(c)+1);
            }
            else {
                freqList.put(c,1);
            }
        }
        
        int windowBegin = 0;
        int windowEnd = 0;
        int characterSetsLeftToMatch = freqList.keySet().size();
        
        while(windowEnd < s2.length()) {
            Character ch = s2.charAt(windowEnd);
            if(freqList.containsKey(ch)) {
                freqList.put(ch,freqList.get(ch)-1);
                if(freqList.get(ch) == 0) {
                    characterSetsLeftToMatch--;
                }
            }
            while(characterSetsLeftToMatch == 0) {
                if((windowEnd - windowBegin + 1) == s1.length()) {
                    return true;
                }
                Character chb = s2.charAt(windowBegin);
                if(freqList.containsKey(chb)) {
                    freqList.put(chb,freqList.get(chb)+1);
                    if(freqList.get(chb) > 0) {
                        characterSetsLeftToMatch++;
                    }
                }
                windowBegin++;
            }
            windowEnd++;
        }
        
        return false;
    }
}
