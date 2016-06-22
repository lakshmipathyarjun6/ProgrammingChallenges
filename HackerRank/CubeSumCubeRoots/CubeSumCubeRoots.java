import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CubeSumCubeRoots {
    
    public static int cubeNumbers(int M, int N) {
        
        int pairs = 0;
        
        for(double i = 1; i <= M; i++) {
            double cbrt1 = Math.cbrt((double)i);
            for(double j = i; j <= N; j++) {
                double cbrt2 = Math.cbrt((double)j);
                double result = Math.pow(cbrt1 + cbrt2, 3);
                if((result == (int)result) || (i == j)){
                    pairs++;
                }
            }
        }
        
        return pairs;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _M;
        _M = Integer.parseInt(in.nextLine());
        
        int _N;
        _N = Integer.parseInt(in.nextLine());
        
        res = cubeNumbers(_M, _N);
        System.out.println(res);
        
    }
    
}