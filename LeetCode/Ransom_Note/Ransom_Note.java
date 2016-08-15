public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> letterFrequencyNote = new HashMap<Character,Integer>();
        Map<Character,Integer> letterFrequencyMagazine = new HashMap<Character,Integer>();
        for(int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            if(letterFrequencyNote.containsKey(ch)) {
                letterFrequencyNote.put(ch,letterFrequencyNote.get(ch)+1);
            }
            else {
                letterFrequencyNote.put(ch,1);
            }
        }
        for(int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            if(letterFrequencyMagazine.containsKey(ch)) {
                letterFrequencyMagazine.put(ch,letterFrequencyMagazine.get(ch)+1);
            }
            else {
                letterFrequencyMagazine.put(ch,1);
            }
        }
        for(Character ch : letterFrequencyNote.keySet()) {
            if(!letterFrequencyMagazine.containsKey(ch) || letterFrequencyNote.get(ch) > letterFrequencyMagazine.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
