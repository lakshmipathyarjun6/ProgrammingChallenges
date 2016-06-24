import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.io.InputStreamReader;
import java.util.regex.*;

// This class gets the necessary information from the website (formatting the token guess and retrieving the JSON reponse)

public class WebFetch {
    public static PrisonGuess playGame(String guess) {
        PrisonGuess prisonguess = new PrisonGuess(); // Default constructor automatically present
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(new URL("http://gallows.hulu.com/play?code=lakshmipathyarjun6@gmail.com" + guess).openStream()));
            String fetchedInfo = inputStream.readLine();
            
            // Get the status
            Pattern thestatus = Pattern.compile("(ALIVE|DEAD|FREE)");
            Matcher m_status = thestatus.matcher(fetchedInfo);
            
            // Get the token
            Pattern thetoken = Pattern.compile("(\\d+)");
            Matcher m_token = thetoken.matcher(fetchedInfo);
            
            // Get the number of remaining guesses
            Pattern therg = Pattern.compile("(\\d)(,)");
            Matcher m_rg = therg.matcher(fetchedInfo);
            
            // Get the state
            Pattern thestate = Pattern.compile("([A-Z_'\\s]+)(\"})");
            Matcher m_state = thestate.matcher(fetchedInfo);
            
            if(m_status.find() && m_token.find() && m_rg.find() && m_state.find()) {
                prisonguess.status = m_status.group();
                prisonguess.token = m_token.group();
                prisonguess.remaining_guesses = Integer.parseInt(m_rg.group(1));
                prisonguess.state = m_state.group(1);
            }
        }
        catch(IOException e) {
            System.err.println(e);
        }
        return prisonguess;
    }
    public static PrisonGuess start() {
        return playGame("");
    }
    public static PrisonGuess guess(PrisonGuess sacrifice, char letter) {
        return playGame("&token="+sacrifice.token+"&guess="+letter);
    }
}