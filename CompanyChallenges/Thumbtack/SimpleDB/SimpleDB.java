import java.io.*;
import java.util.*;

public class SimpleDB {

    private LinkedList<TransactionBlock> blockChain;
    
    public SimpleDB() {
        blockChain = new LinkedList<TransactionBlock>();
        blockChain.add(new TransactionBlock());
    }
    
    public Integer GET(String variableName) {
        return blockChain.getLast().getVariableMapping(variableName);
    }
    
    public void SET(String variableName, Integer value) {
        blockChain.getLast().setVariableMapping(variableName,value);
    }
    
    public Integer NUMEQUALTO(Integer value) {
        return blockChain.getLast().getNumEqualTo(value);
    }
    
    public void BEGIN() {
        TransactionBlock newBlock = new TransactionBlock();
        newBlock.setPreviousBlock(blockChain.getLast());
        blockChain.add(newBlock);
    }
    
    public boolean ROLLBACK() {
        if(blockChain.size() <= 1) {
            return false; // if only one transaction block left, cannot rollback to anything
        }
        blockChain.removeLast();
        return true;
    }
    
    public boolean COMMIT() {
        if(blockChain.size() <= 1) {
            return false; // if only one transaction block left, cannot commit anything
        }
        
        HashMap<String, Integer> finalVariableMappings = new HashMap<String, Integer>();
        HashMap<Integer, Integer> finalValueOccurances = new HashMap<Integer, Integer>();
        
        // First finalize all the variable mappings
        ListIterator<TransactionBlock> blockChainIterator = blockChain.listIterator();
        while(blockChainIterator.hasNext()) {
            TransactionBlock currentBlock = blockChainIterator.next();
            
            // Place all variable mappings into final list. This will ensure that later blocks
            // (more recent transactions) will override earlier block mappings
            finalVariableMappings.putAll(currentBlock.getAllVariableMappings());
        }
        
        // Then get all the occurrances of each variable
        for(Map.Entry<String,Integer> pair : finalVariableMappings.entrySet()) {
            Integer value = pair.getValue();
            Integer numOccurances = finalValueOccurances.get(value);
            if(numOccurances == null) {
                finalValueOccurances.put(value, new Integer(1));
            }
            else {
                finalValueOccurances.put(value, new Integer(numOccurances + 1));
            }
            finalVariableMappings.put(pair.getKey(),pair.getValue());
        }
        
        // Reset the linked list and add only one trasaction block with all the finalized variable mappings
        blockChain = new LinkedList<TransactionBlock>();
        blockChain.add(new TransactionBlock(finalVariableMappings, finalValueOccurances));
        
        return true;
    }

    private static void parseCommand(SimpleDB simpledb, String commandLine) {
        
        String[] commandLineParts = commandLine.split("\\s+");
        String command = commandLineParts[0];
        String variableName = "";
        Integer value = null;
        
        try {
            switch (command) {
                case "GET":
                    variableName = commandLineParts[1];
                    Integer returnValue = simpledb.GET(variableName);
                    if(returnValue != null) {
                        System.out.println(returnValue.toString());
                    }
                    else {
                        System.out.println("NULL");
                    }
                    break;
                case "SET":
                    variableName = commandLineParts[1];
                    value = Integer.parseInt(commandLineParts[2]);
                    simpledb.SET(variableName, value);
                    break;
                case "UNSET":
                    variableName = commandLineParts[1];
                    simpledb.SET(variableName, null);
                    break;
                case "NUMEQUALTO":
                    value = Integer.parseInt(commandLineParts[1]);
                    Integer numOccurances = simpledb.NUMEQUALTO(value);
                    System.out.println(numOccurances.toString());
                    break;
                case "BEGIN":
                    simpledb.BEGIN();
                    break;
                case "ROLLBACK":
                    if(!simpledb.ROLLBACK()) {
                        System.out.println("NO TRANSACTION");
                    }
                    break;
                case "COMMIT":
                    if(!simpledb.COMMIT()) {
                        System.out.println("NO TRANSACTION");
                    }
                    break;
                case "END":
                    System.exit(0);
                    break; // Useless, but gets rid of warnings
                case "":
                    break;
                default:
                    System.out.println("Command " + command + " not recognized");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + commandLine );
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Possibly missing operand: " + commandLine );
        }
    }

    public static void main(String[] args) {
        
        SimpleDB simpledb = new SimpleDB();
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String commandLine = "";

        try {
            while((commandLine = stdin.readLine()) != null) {
                parseCommand(simpledb, commandLine);
            }

        }
        catch(Exception e) {
                e.printStackTrace();
        }
    }
}


class TransactionBlock implements Cloneable {
    
    private TransactionBlock previousBlock;
    
    private HashMap<String, Integer> variableMappings;
    private HashMap<Integer, Integer> valueOccurances;

    public TransactionBlock() {
        variableMappings = new HashMap<String, Integer>();
        valueOccurances = new HashMap<Integer, Integer>();
    }
    
    // Used for commiting all transactions
    public TransactionBlock(HashMap<String, Integer> allVariableMappings, HashMap<Integer, Integer> allValueOccurances) {
        variableMappings = allVariableMappings;
        valueOccurances = allValueOccurances;
    }
    
    public void setPreviousBlock(TransactionBlock targetBlock) {
        previousBlock = targetBlock;
    }
    
    public HashMap<String, Integer> getAllVariableMappings() { // Used only for COMMIT
        return variableMappings;
    }
    
    public Integer getVariableMapping(String name) {
        TransactionBlock currentBlock = this;
        Integer value = currentBlock.variableMappings.get(name);
        
        while(!currentBlock.variableMappings.containsKey(name) && currentBlock.previousBlock != null) {
            currentBlock = currentBlock.previousBlock;
            value = currentBlock.variableMappings.get(name);
        }
        
        return value;
    }
    
    public void setVariableMapping(String name, Integer value) {
        
        // Update old information first
        Integer oldValue = this.getVariableMapping(name);
        if(oldValue != null) {
            Integer oldValueOccurrances = this.getNumEqualTo(oldValue);
            oldValueOccurrances--;
            this.valueOccurances.put(oldValue, oldValueOccurrances);
        }
        
        // Add new information
        if(value != null) {
            Integer currentValueOccurrances = this.getNumEqualTo(value);
            if(currentValueOccurrances != null) {
                currentValueOccurrances++;
                this.valueOccurances.put(value, currentValueOccurrances);
            }
            else {
                this.valueOccurances.put(value, new Integer(1));
            }
        }
        
        this.variableMappings.put(name,value);
        
    }
    
    public Integer getNumEqualTo(Integer val) {
        TransactionBlock currentBlock = this;
        Integer value = currentBlock.valueOccurances.get(val);
        
        while(!currentBlock.valueOccurances.containsKey(val) && currentBlock.previousBlock != null) {
            currentBlock = currentBlock.previousBlock;
            value = currentBlock.valueOccurances.get(val);
        }
        
        if(value == null) {
            value = 0;
        }
        return value;
    }

}



