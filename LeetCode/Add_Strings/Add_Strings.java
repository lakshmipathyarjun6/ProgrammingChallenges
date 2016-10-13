public class Solution {
    public String addStrings(String num1, String num2) {
        String output = "";
        int carry = 0;
        int num1Index = num1.length()-1;
        int num2Index = num2.length()-1;
        
        while(num1Index >= 0 && num2Index >= 0) {
            String digit = String.valueOf(num1.charAt(num1Index) + num2.charAt(num2Index) - '0' - '0' + carry);
            if(Integer.parseInt(digit) >= 10) {
                carry = 1;
                digit = String.valueOf(Integer.parseInt(digit)%10);
            }
            else {
                carry = 0;
            }
            output = digit + output;
            num1Index--;
            num2Index--;
        }
        
        int remainingIndex = Math.max(num1Index,num2Index);
        String largerString = (num1.length() > num2.length()) ? num1 : num2;
        while(remainingIndex >= 0) {
            String digit = String.valueOf(largerString.charAt(remainingIndex) - '0' + carry);
            if(Integer.parseInt(digit) >= 10) {
                carry = 1;
                digit = String.valueOf(Integer.parseInt(digit)%10);
            }
            else {
                carry = 0;
            }
            output = digit + output;
            remainingIndex--;
        }
        output = (carry == 1) ? "1" + output : output;
        
        return output;
    }
}
