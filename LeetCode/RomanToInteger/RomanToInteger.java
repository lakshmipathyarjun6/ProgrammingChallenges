public class Solution {
    
    Map<Character,Integer> numeralVals = new HashMap<Character,Integer>();
    
    public int romanToInt(String s) {
        numeralVals.put('I',1);
        numeralVals.put('V',5);
        numeralVals.put('X',10);
        numeralVals.put('L',50);
        numeralVals.put('C',100);
        numeralVals.put('D',500);
        numeralVals.put('M',1000);
        
        Character previous = null;
        int total = 0;
        
        for(int i = s.length()-1; i >= 0; i--) {
            Character val = s.charAt(i);
            if(previous != null && (
                (val == 'I' && (previous == 'V' || previous == 'X')) ||
                (val == 'X' && (previous == 'L' || previous == 'C')) ||
                (val == 'C' && (previous == 'D' || previous == 'M'))
            ))  {
                total -= numeralVals.get(val);
            }
            else {
                total += numeralVals.get(val);
            }
            previous = val;
        }
        
        return total;
    }
}
