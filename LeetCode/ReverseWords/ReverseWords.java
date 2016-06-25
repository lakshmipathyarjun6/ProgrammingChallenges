public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.isEmpty()) {
            return s;
        }
        
        String [] words = s.split("\\s+");
        StringBuffer buff = new StringBuffer();
        
        for(int i = words.length-1; i >= 0; i--) {
            buff.append(words[i]);
            buff.append(" ");
        }
        
        buff.replace(buff.length()-1,buff.length(),"");
        return buff.toString();
    }
}