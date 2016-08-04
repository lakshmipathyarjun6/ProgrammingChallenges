public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            if(i == 0) {
                result.add(1);
            }
            else {
                List<Integer> newResult = new LinkedList<Integer>();
                for(int j = 0; j < i+1; j++) {
                    int right = (j < result.size()) ? result.get(j) : 0;
                    int left = (j-1 >= 0) ? result.get(j-1) : 0;
                    newResult.add(left + right);
                }
                result = newResult;
            }
        }
        return result;
    }
}
