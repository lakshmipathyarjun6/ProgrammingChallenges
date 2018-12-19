class Solution {
    public char shiftLetter(char input, int shiftAmount) {
        int asciicode = (int) input - (int) 'a';
        int newascii = (asciicode + shiftAmount) % 26 + (int) 'a';
        return (char) newascii;
    }
    
    public String shiftingLetters(String S, int[] shifts) {
        char [] strArr = S.toCharArray();
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }
        for(int i = 0; i < shifts.length; i++) {
            strArr[i] = shiftLetter(strArr[i], shifts[i]);
        }
        return new String(strArr);
    }
}
