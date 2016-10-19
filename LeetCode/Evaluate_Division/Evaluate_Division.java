public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double [] results = new double[queries.length];
        if(queries.length == 0) {
            return results;
        }
        
        Map<String,Map<String,Double>> database = new HashMap<String,Map<String,Double>>();
        for(int i = 0; i < equations.length; i++) {
            String [] equation = equations[i];
            double evaluation = values[i];
            if(database.containsKey(equation[0])) {
                database.get(equation[0]).put(equation[1], evaluation);
            }
            else {
                Map<String,Double> edges = new HashMap<String,Double>();
                edges.put(equation[1], evaluation);
                database.put(equation[0], edges);
            }
            
            if(database.containsKey(equation[1])) {
                database.get(equation[1]).put(equation[0], 1 / evaluation);
            }
            else {
                Map<String,Double> edges = new HashMap<String,Double>();
                edges.put(equation[0], 1 / evaluation);
                database.put(equation[1], edges);
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            String [] query = queries[i];
            results[i] = processQuery(database, query[0], query[1]);
        }
        
        return results;
        
    }
    
    private double processQuery(Map<String,Map<String,Double>> database, String start, String end) {
        if(!database.containsKey(start)) {
            return -1.0;
        }
        
        Map<String,Boolean> visited = new HashMap<String,Boolean>();
        for(String key : database.keySet()) {
            visited.put(key, false);
        }
        
        return processQueryHelper(database,visited,1.0,start,end);
    }
    
    private double processQueryHelper(Map<String,Map<String,Double>> database, Map<String,Boolean> visited, double result, String current, String target) {
        if(current.equals(target)) {
            return result;
        }
        
        visited.put(current,true);
        Map<String,Double> edges = database.get(current);
        double val = -1.0;
        for(String edge : edges.keySet()) {
            if(!visited.get(edge)) {
               val = Math.max(val, processQueryHelper(database,visited,result*edges.get(edge),edge,target));
            }
        }
        
        return val;
    }
    
}

