public class Solution {
    
    Map<Integer,Integer> numberFrequency = new HashMap<Integer,Integer>();
    Map<Character,Integer> interestLetterFrequencies = new HashMap<Character,Integer>();
    Map<Character,Integer> numberLetterMap = new HashMap<Character,Integer>();
    
    private void initialize() {
        for(int i = 0; i < 10; i++) {
            numberFrequency.put(i, 0);
        }
        
        interestLetterFrequencies.put('s', 0);
        interestLetterFrequencies.put('h', 0);
        interestLetterFrequencies.put('v', 0);
        interestLetterFrequencies.put('f', 0);
        interestLetterFrequencies.put('i', 0);
        interestLetterFrequencies.put('o', 0);
        
        numberLetterMap.put('z', 0);
        numberLetterMap.put('o', 1);
        numberLetterMap.put('w', 2);
        numberLetterMap.put('h', 3);
        numberLetterMap.put('f', 4);
        numberLetterMap.put('v', 5);
        numberLetterMap.put('x', 6);
        numberLetterMap.put('s', 7);
        numberLetterMap.put('g', 8);
        numberLetterMap.put('i', 9);
    }
    
    public String originalDigits(String s) {
        initialize();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'z' || ch == 'g' || ch == 'x' || ch == 'w') {
                Integer value = numberLetterMap.get(ch);
                numberFrequency.put(value, numberFrequency.get(value) + 1);
            }
            else if(ch == 's' || ch == 'h' || ch == 'v' || ch == 'f' || ch == 'o' || ch == 'i') {
                interestLetterFrequencies.put(ch, interestLetterFrequencies.get(ch) + 1);
            }
        }
        
        numberFrequency.put(7, interestLetterFrequencies.get('s') - numberFrequency.get(6));
        numberFrequency.put(3, interestLetterFrequencies.get('h') - numberFrequency.get(8));
        numberFrequency.put(5, interestLetterFrequencies.get('v') - numberFrequency.get(7));
        numberFrequency.put(4, interestLetterFrequencies.get('f') - numberFrequency.get(5));
        
        numberFrequency.put(1, interestLetterFrequencies.get('o') - numberFrequency.get(0) - numberFrequency.get(2) - numberFrequency.get(4));
        numberFrequency.put(9, interestLetterFrequencies.get('i') - numberFrequency.get(5) -  numberFrequency.get(6) - numberFrequency.get(8));
        
        String output = "";
        for(Integer val : numberFrequency.keySet()) {
            int timesToRepeat = numberFrequency.get(val);
            while(timesToRepeat > 0) {
                output += String.valueOf(val);
                timesToRepeat--;
            }
        }
        
        return output;
    }
    
}
