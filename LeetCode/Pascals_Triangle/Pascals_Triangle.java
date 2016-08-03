public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<Integer>();
            if(i == 0) {
                newRow.add(1);
                result.add(newRow);
            }
            else {
                List<Integer> prevRow = result.get(i-1);
                for(int j = 0; j < i+1; j++) {
                    int right = (j < prevRow.size()) ? prevRow.get(j) : 0;
                    int left = (j-1 >= 0) ? prevRow.get(j-1) : 0;
                    newRow.add(left + right);
                }
                result.add(newRow);
            }
        }
        return result;
    }
}
