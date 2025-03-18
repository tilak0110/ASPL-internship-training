package OOPs.aggregation;

public class AggregationDemo {
    public static void main(String[] args) {
        Department dept = new Department("IT");
        Employee emp = new Employee("Tilak", dept);

        emp.display();
    }
}