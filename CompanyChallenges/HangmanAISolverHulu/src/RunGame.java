// Play the game

public class RunGame {
    public static void main(String [] args) {
        
        HangmanSolverAI solver = new HangmanSolverAI();
        PrisonGuess sacrifice = WebFetch.start();
        
        int guessNum = 0;
        
        while(sacrifice.status.equals("ALIVE")) {
            System.out.println(sacrifice.state);
            char letter = solver.makeGuess(sacrifice.state);
            PrisonGuess newState = WebFetch.guess(sacrifice, letter);
            guessNum++;
            
            if(sacrifice.state.equals(newState.state)) {
                solver.updateStatus(letter, false);
                System.out.println(letter + " is incorrect. Number of attempts remaining: " + newState.remaining_guesses);
            }
            else if(newState.status.equals("DEAD")) {
                System.out.println(letter + " is incorrect.");
            }
            else {
                solver.updateStatus(letter, true);
                System.out.println(letter + " is correct!");
            }
            sacrifice = newState;
        }
        
        if(sacrifice.status.equals("DEAD")){
            System.out.println(sacrifice.state);
            System.out.println("You....have failed.");
        }
        if(sacrifice.status.equals("FREE")){
            System.out.println(sacrifice.state);
            System.out.println("Impressive...most impressive.");
        }
    }
}