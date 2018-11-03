i/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee employee = null;
        for(Employee e : employees) {
            if(e.id == id) {
                employee = e;
            }
        }
        if(employee == null) {
            return 0;
        }
        if(employee.subordinates.size() == 0) {
            return employee.importance;
        }
        else {
            int total = 0;
            for(Integer subordinateId : employee.subordinates) {
                total += getImportance(employees, subordinateId);
            }
            return employee.importance + total;
        }
    }
}
