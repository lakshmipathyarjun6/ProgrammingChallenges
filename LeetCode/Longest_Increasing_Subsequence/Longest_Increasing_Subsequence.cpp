class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.empty()) {
            return 0;
        }
        
        vector<int> list;
        for(int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            if(list.size() == 0) {
                list.push_back(num);
            }
            else if(num > list.at(list.size()-1)) {
                list.push_back(num);
            }
            else {
                int j = 0; 
                int k = list.size() - 1;
                while(j < k) {
                    int mid = (j+k)/2;
                    if(list.at(mid) < num) {
                        j = mid+1;
                    }
                    else {
                        k = mid;
                    }
                }
                list[k] = num;
            }
        }
        
        return list.size();
    }
};

