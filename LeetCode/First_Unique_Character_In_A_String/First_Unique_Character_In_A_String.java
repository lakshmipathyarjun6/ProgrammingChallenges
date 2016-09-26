public class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> foundChars = new HashMap<Character,Integer>();
        Set<Character> duplicateChars = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(duplicateChars.contains(ch)) {
                continue;
            }
            else if(foundChars.containsKey(ch)) {
                duplicateChars.add(ch);
                foundChars.remove(ch);
            }
            else {
                foundChars.put(ch,i);
            }
        }
        
        if(foundChars.size() > 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(Character ch : foundChars.keySet()) {
                pq.offer(foundChars.get(ch));
            }
            return pq.poll();
        }
        
        return -1;
    }
}
