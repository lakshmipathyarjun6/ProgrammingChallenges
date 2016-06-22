import java.io.*;
import java.util.*;

public class Frenemy {
    
    public static int determine_existance(ArrayList<Person> people, Person current, Person previous, Person goal, String frenemy) {
        int result = 0;
        System.out.println(current.toString());
        if(frenemy.isEmpty()) {
            System.out.println("Got here: " + current.getId() + " " + goal.getId());
            if(current.getId() == goal.getId()) {
            //    System.out.println("And here");
                result = 1;
            }
            else {
                result = 0;
            }
        }
        
        else {
            if(frenemy.charAt(0) == 'F') {
                for(int i = 0; i < current.getFriends().size(); i++) {
                    if(previous == null || previous != current.getFriends().get(i)) {
                        result = determine_existance(people, current.getFriends().get(i), current, goal, frenemy.substring(1));
                        if(result == 1) {
                            break;
                        }
                    }
                }
            }
        
            else { // Must be 'E'
                for(int i = 0; i < current.getEnemies().size(); i++) {
                    if(previous == null || previous != current.getEnemies().get(i)) {
                        result = determine_existance(people, current.getEnemies().get(i), current, goal, frenemy.substring(1));
                        if(result == 1) {
                            break;
                        }
                    }
                }
            }
        }
        
       // System.out.println("But also here");
        return result;
    }
    
    public static int determine_existance(String [][] relationships, int n, int current, Integer previous, int goal, String frenemy) {
        int result = 0;
        //System.out.println(current.toString());
        System.out.println("Got here: " + current + " " + goal);
        
        if(frenemy.isEmpty()) {
            if(current == goal) {
                //    System.out.println("And here");
                result = 1;
            }
            else {
                result = 0;
            }
        }
        
        else {
            if(frenemy.charAt(0) == 'F') {
                for(int j = 0; j < n; j++) {
                    if(relationships[current][j].equals("F") && (previous == null || previous != j)) {
                        result = determine_existance(relationships, n, j, current, goal, frenemy.substring(1));
                        if(result == 1) {
                            break;
                        }
                    }
                }
            }
            
            else {
                for(int j = 0; j < n; j++) {
                    if(relationships[current][j].equals("E") && (previous == null || previous != j)) {
                        result = determine_existance(relationships, n, j, current, goal, frenemy.substring(1));
                        if(result == 1) {
                            break;
                        }
                    }
                }
            }
        }
        
        // System.out.println("But also here");
        return result;
    }
    
    public static int is_Frenemy(int n, String frenemy, int x, int y, String [][] relationships) {
        
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i = 0; i < n; i++) {
            people.add(new Person(i));
        }
        for(int i = 0; i < n; i++) {
            Person currentPerson = people.get(i);
            for(int j = 0; j < n; j++) {
                //System.out.println("Got here for person " + i + " " + relationships[i][j]);
                if(relationships[i][j].equals("F")) {
                    currentPerson.addFriend(people.get(j));
                }
                else if(relationships[i][j].equals("E")) {
                    currentPerson.addEnemy(people.get(j));
                }
            }
        }
        
        /*for(int i = 0; i < n; i++) {
            System.out.println(people.get(i).toString());
        } */
        
        //return determine_existance(people, people.get(x), null, people.get(y), frenemy);
        return determine_existance(relationships, n, x, null, y, frenemy);
    }
    
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.flush();
        String submittedString = "";
        try {
            submittedString = stdin.readLine();
            int numLines = Integer.parseInt(submittedString);
            //HashMap<Integer,Integer> orders = new HashMap<Integer,Integer>();
            String [][] relationships = new String[numLines][numLines];
            for (int i = 0; i < numLines; i++) {
                String temp = stdin.readLine();
                String [] splitarr = temp.split("\\s+");
                for(int j = 0; j < numLines; j++) {
                    relationships[i][j] = splitarr[j];
                }
            }
            String queryString = stdin.readLine();
            String [] splitarr = queryString.split("\\s+");
            int result = is_Frenemy(numLines, splitarr[2], Integer.parseInt(splitarr[0]), Integer.parseInt(splitarr[1]), relationships);
            System.out.println(result);
       /*     for (int i = 0; i < numLines; i++) {
                System.out.print("[");
                for(int j = 0; j < numLines; j++) {
                    System.out.print(" " + relationships[i][j] + " ");
                }
                System.out.print("]");
                System.out.println();
            } */
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}

class Person {
    
    private int id;
    private ArrayList<Person> friends;
    private ArrayList<Person> enemies;
    
    public Person (int id) {
        this.id = id;
        this.friends = new ArrayList<Person>();
        this.enemies = new ArrayList<Person>();
    }
    
    public void addFriend (Person person) {
        friends.add(person);
    }
    
    public void addEnemy (Person person) {
        enemies.add(person);
    }
    
    public int getId() {
        return this.id;
    }
    
    public ArrayList<Person> getFriends() {
        return this.friends;
    }
    
    public ArrayList<Person> getEnemies() {
        return this.enemies;
    }
    
    public String toString() {
        String formattedString = "Person ";
        formattedString += this.id;
        
        formattedString += ": Friends:[";
        for(int i = 0; i < friends.size(); i++) {
            formattedString += " ";
            formattedString += friends.get(i).id;
            formattedString += " ";
        }
        formattedString += "] ";
        
        formattedString += "Enemies:[";
        for(int i = 0; i < enemies.size(); i++) {
            formattedString += " ";
            formattedString += enemies.get(i).id;
            formattedString += " ";
        }
        
        formattedString += "]";
        return formattedString;
    }
}










