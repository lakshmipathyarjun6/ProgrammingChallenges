public class Solution {
    
    Set<Character> vowels = new HashSet(Arrays.asList(new Character[] { 'A', 'a' , 'E', 'e' , 'I', 'i', 'O', 'o', 'U', 'u' }));
    
    public String reverseVowels(String s) {
        
        char [] str = s.toCharArray();
        
        int head = 0;
        int tail = s.length()-1;
        
        while(tail > head) {
            if(vowels.contains(str[head]) && vowels.contains(str[tail])) {
                Character temp = s.charAt(head);
                str[head] = str[tail];
                str[tail] = temp;
                head++;
                tail--;
            }
            else if(vowels.contains(str[head])) {
                tail--;
            }
            else {
                head++;
            }
        }
        
        return new String(str);
        
    }
}