public class Solution {
    public String convert(String s, int numRows) {
        if(s.equals("") || numRows == 1) {
            return s;
        }
        
        int numSpaces = numRows - 2;
        int fullCollSpacing = numRows + numSpaces;
        
        List<StringBuffer> buffs = new ArrayList<StringBuffer>();
        for(int i = 0; i < numRows; i++) {
            buffs.add(new StringBuffer());
        }
        
        int buffInd = 0;
        int strInd = 0;
        int nextFullColIndex = 0;
        while(strInd < s.length()) {
            
            if(strInd == nextFullColIndex) {
                while(true) {
                    buffs.get(buffInd).append(s.charAt(strInd));
                    strInd++;
                    if(strInd >= s.length()) {
                        break;
                    }
                    buffInd = (buffInd + 1) % numRows;
                    if(buffInd == 0) {
                        break;
                    }
                }
                nextFullColIndex += fullCollSpacing;
            }
            
            else {
                int charIndex = numRows - 2;
                while(charIndex > 0) {
                    if(buffInd == charIndex) {
                        buffs.get(buffInd).append(s.charAt(strInd));
                        strInd++;
                        if(strInd >= s.length()) {
                            break;
                        }
                        charIndex--;
                    }
                    else {
                        buffs.get(buffInd).append(" ");
                    }
                    buffInd = (buffInd + 1) % numRows;
                }
                while(buffInd != 0) {
                    buffs.get(buffInd).append(" ");
                    buffInd = (buffInd + 1) % numRows;
                }
            }
            
        }
        
        StringBuffer master = new StringBuffer();
        for(int i = 0; i < buffs.size(); i++) {
            master.append(buffs.get(i).toString().replaceAll("\\s+",""));
        }
        
        return master.toString();
    }
}
