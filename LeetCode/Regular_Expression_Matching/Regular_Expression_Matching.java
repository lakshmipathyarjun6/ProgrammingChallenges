class Solution {
    
    public Queue<String> tokenize(String input) {
        Queue<String> tokens = new LinkedList<String>();
        
        String token = "";
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if(c.equals('*')) {
                token += c.toString();
            }
            else {
                if(!token.equals("")) {
                    tokens.offer(token);
                }
                token = c.toString();
            }
        }
        if(!token.equals("")) {
            tokens.offer(token);
        }
        
        return tokens;
    }
    
    public Queue<String> resolveOrdering(Queue<String> tokens) {
        Queue<String> reorderedTokens = new LinkedList<String>();
        String tokenPrior = "";
        
        while(!tokens.isEmpty()) {
            String token = tokens.poll();
            if(tokenPrior.equals("")) {
                tokenPrior = token;
            }
            else if(tokenPrior.length() > 1 && tokenPrior.charAt(1) == '*' && tokenPrior.charAt(0) == token.charAt(0)) {
                if(token.length() == 1 || token.charAt(1) != '*') {
                    reorderedTokens.offer(token);
                }
            }
            else {
                reorderedTokens.offer(tokenPrior);
                tokenPrior = token;
            }
        }
        if(!tokenPrior.equals("")) {
            reorderedTokens.offer(tokenPrior);
        }
        
        return reorderedTokens;
    }
    
    public State createNFA(Queue<String> tokens) {
        State startState = new State();
        State currentState = startState;
        while(!tokens.isEmpty()) {
            String token = tokens.poll();
            State nextState = new State();
            if(token.length() > 1 && token.charAt(1) == '*') {
                Character terminalCharacter = token.charAt(0);
                currentState.transitionTable.put(terminalCharacter.toString(), nextState);
                currentState.transitionTable.put("epsilon", nextState);
                nextState.transitionTable.put(terminalCharacter.toString(), nextState);
            }
            else {
                currentState.put(token, nextState);
            }
            currentState.put("temp", nextState);
            currentState = nextState;
        }
        currentState.acceptState = true;
        
        return startState;
    }
    
    public void propogateAcceptStates(State current) {
        if(current.containsKey("temp")) {
            propogateAcceptStates(current.get("temp"));
        }
        if(current.containsKey("epsilon")) {
            current.acceptState = current.get("epsilon").acceptState;
        }
    }
    
    public boolean validateExpression(State dfa, String expression) {
        if(expression.equals("")) {
            return dfa.acceptState;
        }
        Character c = expression.charAt(0);
        String key = c.toString();
        boolean evalKey = false;
        boolean evalDot = false;
        boolean evalEps = false;
        if(dfa.containsKey(key)) {
            evalKey = validateExpression(dfa.get(key), expression.substring(1));
        }
        if(dfa.containsKey(".")) {
            evalDot = validateExpression(dfa.get("."), expression.substring(1));
        }
        if(dfa.containsKey("epsilon")) {
            evalEps = validateExpression(dfa.get("epsilon"), expression);
        }
        return evalKey || evalDot || evalEps;
    }
    
    public boolean isMatch(String s, String p) {
        Queue<String> tokens = tokenize(p);
        
        tokens = resolveOrdering(tokens);
        
        for (String token : tokens) {
            System.out.println(token);
        }
        System.out.println();
        
        State automaton = createNFA(tokens);
        State automatonRunner = automaton;
        
        propogateAcceptStates(automaton);
        
        while(automatonRunner != null) {
            System.out.println(automatonRunner.acceptState);
            for(String token : automatonRunner.transitionTable.keySet()) {
                System.out.println(token);
            }
            System.out.println();
            automatonRunner = automatonRunner.get("temp");
        }
        
        return validateExpression(automaton, s);
    }
}

class State {
    boolean acceptState;
    Map<String, State> transitionTable;
    
    public State() {
        acceptState = false;
        transitionTable = new HashMap<String, State>();
    }
    
    public State get(String key) {
        return transitionTable.get(key);
    }
    
    public State put(String key, State value) {
        return transitionTable.put(key, value);
    }
    
    public void remove(String key) {
        transitionTable.remove(key);
    }
    
    public boolean containsKey(String key) {
        return transitionTable.containsKey(key);
    }
}
