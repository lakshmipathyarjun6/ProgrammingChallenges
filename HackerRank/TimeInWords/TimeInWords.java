import java.io.*;
import java.util.*;

public class TimeInWords {
    
    private static HashMap<Integer,String> numInWords = new HashMap<Integer,String>();
    
    public static void initTable () {
        numInWords.put(1,"one");
        numInWords.put(2,"two");
        numInWords.put(3,"three");
        numInWords.put(4,"four");
        numInWords.put(5,"five");
        numInWords.put(6,"six");
        numInWords.put(7,"seven");
        numInWords.put(8,"eight");
        numInWords.put(9,"nine");
        numInWords.put(10,"ten");
        numInWords.put(11,"eleven");
        numInWords.put(12,"twelve");
        numInWords.put(13,"thirteen");
        numInWords.put(14,"fourteen");
        numInWords.put(15,"fifteen");
        numInWords.put(16,"sixteen");
        numInWords.put(17,"seventeen");
        numInWords.put(18,"eighteen");
        numInWords.put(19,"nineteen");
        numInWords.put(20,"twenty");
        numInWords.put(21,"twenty one");
        numInWords.put(22,"twenty two");
        numInWords.put(23,"twenty three");
        numInWords.put(24,"twenty four");
        numInWords.put(25,"twenty five");
        numInWords.put(26,"twenty six");
        numInWords.put(27,"twenty seven");
        numInWords.put(28,"twenty eight");
        numInWords.put(29,"twenty nine");
    }
    
    public static String convertToWords(Integer hour, Integer minutes) {
        initTable();
        String wordHours = numInWords.get(hour);
        String finalString = "";
        if(minutes == 0) {
            return wordHours + " o' clock";
        }
        String pastFuture = "";
        String interestHour = "";
        String mins = "";
        String oneCorrection = "";
        if(minutes == 1 || minutes == 59) {
            oneCorrection = "minute";
        }
        else {
            oneCorrection = "minutes";
        }
        if(minutes <= 30) {
            interestHour = wordHours;
            if(minutes == 15) {
                return "quarter past " + interestHour;
            }
            else if(minutes == 30) {
                return "half past " + interestHour;
            }
            mins = numInWords.get(minutes);
            pastFuture = "past";
        }
        else {
            interestHour = numInWords.get((hour + 1) % 12);
            if(minutes == 45) {
                return "quarter to " + interestHour;
            }
            mins = numInWords.get(60 - minutes);
            pastFuture = "to";
        }
        finalString = mins + " " + oneCorrection + " " + pastFuture + " " + interestHour;
        return finalString;
    }
    
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int hours = Integer.parseInt(submittedString);
            submittedString = stdin.readLine();
            int minutes = Integer.parseInt(submittedString);
            String timeString = "";
            timeString = convertToWords(hours,minutes);
            System.out.println(timeString);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
