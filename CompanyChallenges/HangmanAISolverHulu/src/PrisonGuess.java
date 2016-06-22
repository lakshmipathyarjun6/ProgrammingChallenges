// Simple class to represent the guess for a prisoner

public class PrisonGuess {
    public String status;
    public String token;
    public String state;
    public int remaining_guesses;
    
    // Override the object toString method - mostly for testing purposes
    public String toString() {
        return "status: " + status + " token: " + token + " state: " + state + " remaining guesses: " + remaining_guesses;
    }
}