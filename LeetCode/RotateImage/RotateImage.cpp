class Solution {
    public:
    void rotate(vector<vector<int>>& matrix) {
        int size = matrix.size();
        for(int layer = 0; layer < size / 2; layer++) {
            int first = layer;
            int last = size - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
};