public class Solution {
    public String intToRoman(int num) {
        StringBuffer buff = new StringBuffer();
        
        while(num >= 1000) {
            buff.append("M");
            num -= 1000;
        }
        
        if(num >= 900) {
            buff.append("CM");
            num -= 900;
        }
        else if(num >= 500) {
            buff.append("D");
            num -= 500;
        }
        else if(num >= 400) {
            buff.append("CD");
            num -= 400;
        }
        
        while(num >= 100) {
            buff.append("C");
            num -= 100;
        }
        
        if(num >= 90) {
            buff.append("XC");
            num -= 90;
        }
        else if(num >= 50) {
            buff.append("L");
            num -= 50;
        }
        else if(num >= 40) {
            buff.append("XL");
            num -= 40;
        }
        
        while(num >= 10) {
            buff.append("X");
            num -= 10;
        }
        
        if(num >= 9) {
            buff.append("IX");
            num -= 9;
        }
        else if(num >= 5) {
            buff.append("V");
            num -= 5;
        }
        else if(num >= 4) {
            buff.append("IV");
            num -= 4;
        }
        
        while(num > 0) {
            buff.append("I");
            num -= 1;
        }
        
        return buff.toString();
    }
}
