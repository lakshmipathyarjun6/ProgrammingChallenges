public class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }
 
        StringBuffer sb = new StringBuffer(num);
        for(int j = 0; j < k; j++) {
            int i = 0;
            while(i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i+1)){
                i++;
            }
            sb.delete(i, i+1);
        }
    
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0,1);
        }
 
        if(sb.length()==0){
            return "0";
        }
 
        return sb.toString();
    }
}
