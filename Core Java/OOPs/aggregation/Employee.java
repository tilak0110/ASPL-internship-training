package OOPs.aggregation;

class Employee {
    String empName;
    Department department; // Aggregation

    public Employee(String empName, Department department) {
        this.empName = empName;
        this.department = department;
    }

    void display() {
        System.out.println("Employee: " + empName);
        System.out.println("Department: " + department.deptName);
    }
}