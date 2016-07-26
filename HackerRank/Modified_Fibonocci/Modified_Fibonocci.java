import java.io.*;
import java.util.*;
import java.math.*;

public class Modified_Fibonocci {
    
    public static BigInteger computeFibNum(Integer A,Integer B,Integer N) {
        BigInteger biA = new BigInteger(A.toString());
        BigInteger biB = new BigInteger(B.toString());
        for(int i = 2; i < N; i++) {
            BigInteger nVal;
            nVal = biA.add(biB.multiply(biB));
            biA = biB;
            biB = nVal;
        }
        return biB;
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            String [] splitarr = submittedString.split("\\s+");
            Integer A = Integer.parseInt(splitarr[0]);
            Integer B = Integer.parseInt(splitarr[1]);
            Integer N = Integer.parseInt(splitarr[2]);
            BigInteger fibnum = computeFibNum(A,B,N);
            System.out.println(fibnum.toString());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
