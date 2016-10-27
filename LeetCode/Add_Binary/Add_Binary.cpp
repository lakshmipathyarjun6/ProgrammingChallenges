class Solution {
public:
    string addBinary(string a, string b) {
        string smallerString = (a.length() < b.length()) ? a : b;
        string largerString = (a.length() < b.length()) ? b : a;

        int cout = 0;
        string outputString;
        
        for(int i = 0; i < largerString.length(); i++) {
            int largerIndex = largerString.length() - i - 1;
            int smallerIndex = smallerString.length() - i - 1;
            int lsval = largerString[largerIndex] - '0';
            int ssval = (smallerIndex >= 0) ? smallerString[smallerIndex] - '0' : 0;
            int sum = (smallerIndex >= 0) ? lsval ^ ssval ^ cout : lsval ^ cout;
            cout = (smallerIndex >= 0) ? (lsval & ssval) | (lsval & cout) | (ssval & cout) : (lsval & cout);
            outputString.append(to_string(sum));
        }
        
        if(cout == 1) {
            outputString.append("1");
        }
        
        reverse(outputString.begin(),outputString.end());
        
        return outputString;
    }
};
