import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;


// This is the class that actually makes the educated guess about the next letter

public class HangmanSolverAI {
    
    private Map<Integer, List<String>> guesslist = new HashMap<Integer, List<String>>();
    private Set<Character> correctguesses = new HashSet<Character>();
    private Set<Character> incorrectguesses = new HashSet<Character>();
    
    // Build a MASSIVE word library from every single file in lib
    // Credit goes to SCOWL for helping to compile an extensive list of words
    // Some pruning was done on the files
    HangmanSolverAI() {
        try {
            for (File f : new File("../lib/").listFiles()) {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                for (String str; (str = reader.readLine()) != null;) {
                    str = str.trim();
                    if (!guesslist.containsKey(str.length())) {
                        guesslist.put(str.length(), new ArrayList<String>());
                    }
                    guesslist.get(str.length()).add(str);
                }
            }
        }
        catch(IOException e) {
            System.err.println(e);
        }
    }
    
    public char makeGuess(String wordstate) {
        
        // Initial setup
        List<String> statelist = new ArrayList<String>(Arrays.asList(wordstate.split("[^A-Z_']+")));
        StringBuilder exclude = new StringBuilder();
        for(Iterator<Character> iex = incorrectguesses.iterator(); iex.hasNext();) {
            exclude.append(iex.next());
        }
        List<String> possibleWords = new ArrayList<String>();
        
        // Find words that can be possible fits for all the unknown words
        for(String wordguess : statelist) {
            String word = wordguess.toLowerCase();
            if(word.contains("_")) {
                Pattern regexpat = Pattern.compile(word.replace("_", (exclude.length() > 0) ? String.format("[a-z&&[^%s]]",exclude) : "[a-z]"));
                if(guesslist.containsKey(word.length())) {
                    for(String guessword : guesslist.get(word.length())) {
                        Matcher match = regexpat.matcher(guessword);
                        if(match.find()) {
                            possibleWords.add(guessword);
                        }
                    }
                }
            }
        }
        
        // First get a frequency list of all letters among the list of possible words
        System.out.println("Possible words: " + possibleWords.toString());
        Map<Character, Integer> letterfrequency = new HashMap<Character, Integer>();
        for(String wordd : possibleWords) {
            Set<String> letters = new HashSet<String>();
            for(char letter : wordd.toCharArray()) {
                if(!letters.contains(letter)) {
                    if(!letterfrequency.containsKey(letter)) {
                        letterfrequency.put(letter, 1);
                    }
                    else {
                        letterfrequency.put(letter, letterfrequency.get(letter)+1);
                    }
                }
            }
        }
        
        // This frequency table will be used for dealing with ties
        // Source http://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
        Map<Character, Double> commonEnglishLetters = new HashMap<Character, Double>();
        commonEnglishLetters.put('a',8.12);
        commonEnglishLetters.put('b',1.49);
        commonEnglishLetters.put('c',2.71);
        commonEnglishLetters.put('d',4.32);
        commonEnglishLetters.put('e',12.02);
        commonEnglishLetters.put('f',2.30);
        commonEnglishLetters.put('g',2.03);
        commonEnglishLetters.put('h',5.92);
        commonEnglishLetters.put('i',7.31);
        commonEnglishLetters.put('j',0.10);
        commonEnglishLetters.put('k',0.69);
        commonEnglishLetters.put('l',3.98);
        commonEnglishLetters.put('m',2.61);
        commonEnglishLetters.put('n',6.95);
        commonEnglishLetters.put('o',7.68);
        commonEnglishLetters.put('p',1.82);
        commonEnglishLetters.put('q',0.11);
        commonEnglishLetters.put('r',6.02);
        commonEnglishLetters.put('s',6.28);
        commonEnglishLetters.put('t',9.10);
        commonEnglishLetters.put('u',2.88);
        commonEnglishLetters.put('v',1.11);
        commonEnglishLetters.put('w',2.09);
        commonEnglishLetters.put('x',0.17);
        commonEnglishLetters.put('y',2.11);
        commonEnglishLetters.put('z',0.07);
        
        // Find the highest frequency letter - it would be the 'best' guess
        char letterguess = 'a';
        int frequency = 0;
        boolean none = true;
        List<Character> tieList = new ArrayList<Character>();
        for(char c = 'a'; c <= 'z'; ++c) {
            if(!correctguesses.contains(c) && !incorrectguesses.contains(c)) {
                Integer letfreq = letterfrequency.get(c);
                if(letfreq != null && letfreq > frequency) {
                    tieList.clear();
                    letterguess = c;
                    frequency = letfreq;
                    none = false;
                    tieList.add(c);
                }
                else if(letfreq != null && letfreq == frequency) {
                    tieList.add(c);
                }
            }
        }
        
        // Deal with ties
        if(tieList.size() > 1) {
            double maxfreq = 0;
            for(char let : tieList) {
                if((Double)commonEnglishLetters.get(let) > maxfreq) {
                    letterguess = let;
                    maxfreq = (Double)commonEnglishLetters.get(let);
                }
            }
        }
        
        // Out of letters to guess
        if(none) {
            for(char c = 'a'; c <= 'z'; ++c) {
                if(!correctguesses.contains(c) && !incorrectguesses.contains(c)) {
                    return c;
                }
            }
        }
        
        // We now have our recommendation
        return letterguess;
    }
    
    public void updateStatus(char letter, boolean success) {
        if(success) {
            correctguesses.add(letter);
        }
        else {
            incorrectguesses.add(letter);
        }
    }
}