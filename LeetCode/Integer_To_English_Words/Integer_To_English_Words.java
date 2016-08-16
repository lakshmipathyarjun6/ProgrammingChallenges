public class Solution {

    Map<Integer,String> numberWordConversions;
    
    private void initializeMaps() {
        numberWordConversions = new HashMap<Integer,String>();
        numberWordConversions.put(1,"One");
        numberWordConversions.put(2,"Two");
        numberWordConversions.put(3,"Three");
        numberWordConversions.put(4,"Four");
        numberWordConversions.put(5,"Five");
        numberWordConversions.put(6,"Six");
        numberWordConversions.put(7,"Seven");
        numberWordConversions.put(8,"Eight");
        numberWordConversions.put(9,"Nine");
        numberWordConversions.put(10,"Ten");
        numberWordConversions.put(11,"Eleven");
        numberWordConversions.put(12,"Twelve");
        numberWordConversions.put(13,"Thirteen");
        numberWordConversions.put(14,"Fourteen");
        numberWordConversions.put(15,"Fifteen");
        numberWordConversions.put(16,"Sixteen");
        numberWordConversions.put(17,"Seventeen");
        numberWordConversions.put(18,"Eighteen");
        numberWordConversions.put(19,"Nineteen");
        numberWordConversions.put(20,"Twenty");
        numberWordConversions.put(30,"Thirty");
        numberWordConversions.put(40,"Forty");
        numberWordConversions.put(50,"Fifty");
        numberWordConversions.put(60,"Sixty");
        numberWordConversions.put(70,"Seventy");
        numberWordConversions.put(80,"Eighty");
        numberWordConversions.put(90,"Ninety");
    }
    
    private String convertNumToWord(String num) {
        String result = "";
        
        int onesBuffer = 0;
        int tripletValue = 0;
        int tripletMultiplier = 1;
        int nextPlace = 0;
        boolean unflushedOnesBuffer = false;
        for(int i = 0; i < num.length(); i++) {
            int index = num.length() - i - 1;
            int value = Character.getNumericValue(num.charAt(index)) * tripletMultiplier;
            if(nextPlace == 0) {
                onesBuffer = value;
                unflushedOnesBuffer = true;
            }
            else if(nextPlace == 1) {
                if(value == 10) {
                    result = numberWordConversions.get(value + onesBuffer) + " " + result; 
                }
                else {
                    if(onesBuffer > 0) {
                        result = numberWordConversions.get(onesBuffer) + " " + result;
                    }
                    if(value > 0) {
                        result = numberWordConversions.get(value) + " " + result;
                    }
                }
                unflushedOnesBuffer = false;
            }
            else {
                if(value > 0) {
                    result = numberWordConversions.get(value / 100) + " Hundred " + result;
                }
            }

            nextPlace = (nextPlace+1) % 3;
            tripletMultiplier = (tripletMultiplier < 100) ? tripletMultiplier*10 : 1;
        }
        if(unflushedOnesBuffer) {
            result = numberWordConversions.get(onesBuffer) + " " + result;
        }
        
        return (result.length() > 0) ? result.substring(0,result.length()-1) : result;
    }
    
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        initializeMaps();
        String strnum = String.valueOf(num);
        int len = strnum.length();

        String hundreds = "";
        String thousands = "";
        String millions = "";
        String billions = "";
        
        int startPos = 0;
        if(len > 9) {
            billions = convertNumToWord(strnum.substring(0,len-9)) + " Billion ";
        }
        if(len > 6) {
            startPos = (len-9 >= 0) ? len-9 : 0;
            String val = convertNumToWord(strnum.substring(startPos,len-6));
            if(val.length() > 0) {
                millions = val + " Million ";
            }
        }
        if(len > 3) {
            startPos = (len-6 >= 0) ? len-6 : 0;
            String val = convertNumToWord(strnum.substring(startPos,len-3));
            if(val.length() > 0) {
                thousands = val + " Thousand ";
            }
        }
        startPos = (len-3 >= 0) ? len-3 : 0;
        String val = convertNumToWord(strnum.substring(startPos,len));
        if(val.length() > 0) {
            hundreds = val + " ";
        }

        String finalResult = billions + millions + thousands + hundreds;
        return finalResult.substring(0,finalResult.length()-1);
    }
}
