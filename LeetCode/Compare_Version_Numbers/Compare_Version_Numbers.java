public class Solution {
    public int compareVersion(String version1, String version2) {
        String [] version1Split = version1.split("\\.");
        while(version1Split.length > 0 && Integer.parseInt(version1Split[version1Split.length-1]) == 0) {
           version1Split = Arrays.copyOf(version1Split, version1Split.length-1); 
        }
        
        String [] version2Split = version2.split("\\.");
        while(version2Split.length > 0 && Integer.parseInt(version2Split[version2Split.length-1]) == 0) {
           version2Split = Arrays.copyOf(version2Split, version2Split.length-1); 
        }
        
        int index = 0;
        int largerMaxInd = Math.max(version1Split.length, version2Split.length);
        while(index < largerMaxInd) {
            if(index >= version2Split.length) {
                return 1;
            }
            else if(index >= version1Split.length) {
                return -1;
            }
            else {
                Integer v1val = Integer.parseInt(version1Split[index]);
                Integer v2val = Integer.parseInt(version2Split[index]);
                if(v1val != v2val) {
                    return (v1val > v2val) ? 1 : -1; 
                }
            }
            index++;
        }
        return 0;
    }
}
