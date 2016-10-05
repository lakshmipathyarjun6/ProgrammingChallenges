public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? -Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        ArrayList<int[]> result = new ArrayList<int[]>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        int [][] output = new int[people.length][2];
        for(int i = 0; i < output.length; i++) {
            int [] person = result.get(i);
            output[i][0] = person[0];
            output[i][1] = person[1];
        }
        return output;
    }
} 
