public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        List<String> largestInteger = new LinkedList<String>();
        for(int i = 0; i < nums.length; i++) {
            largestInteger.add(String.valueOf(nums[i]));
        }
        
        Collections.sort(largestInteger, new Comparator<String>(){
            public int compare(String s1, String s2){
                String toEnd = s1 + s2;
                String toFront = s2 + s1;
                return (-1)*toEnd.compareTo(toFront);
            }
        });
        
        StringBuffer res = new StringBuffer();
        while(largestInteger.size() > 1 && largestInteger.get(0).equals("0")) {
             largestInteger.remove(0);
        }
        for(int i = 0; i < largestInteger.size(); i++) {
            res.append(largestInteger.get(i));
        }
        return res.toString();
    }
}
