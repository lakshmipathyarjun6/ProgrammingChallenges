import java.io.*;
import java.util.*;

public class Taum_Bday {
    
    public static long computeMinCost(long blackTotal, long whiteTotal, long blackPrice, long whitePrice, long conversionPrice) {
        
        long minCost = (blackTotal * Math.min(blackPrice,whitePrice + conversionPrice)) + (whiteTotal * Math.min(whitePrice,blackPrice + conversionPrice));
        return minCost;
        
    }

    public static void main(String[] args) {
    
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        
        ArrayList<Long> minvals = new ArrayList<Long>();
        
        try {
            submittedString = stdin.readLine();
            Integer numCases = Integer.parseInt(submittedString);
        
            for (int i = 0; i < numCases; i++) {
                String giftCounts = stdin.readLine();
                String [] splitarr = giftCounts.split("\\s+");
                Long numBlackGifts = Long.parseLong(splitarr[0]);
                Long numWhiteGifts = Long.parseLong(splitarr[1]);
                
                String prices = stdin.readLine();
                splitarr = prices.split("\\s+");
                Long blackPrice = Long.parseLong(splitarr[0]);
                Long whitePrice = Long.parseLong(splitarr[1]);
                Long conversionPrice = Long.parseLong(splitarr[2]);
                
                minvals.add(computeMinCost(numBlackGifts,numWhiteGifts,blackPrice,whitePrice,conversionPrice));
            }
        
            for(int i = 0; i < minvals.size(); i++) {
                System.out.println(minvals.get(i));
            }
        
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
