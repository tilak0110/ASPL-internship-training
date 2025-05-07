package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " ($" + salary + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000),
                new Employee("Alice", 7000),
                new Employee("Bob", 4000)
        );

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingInt(e -> e.salary)) // Sort by salary
                .collect(Collectors.toList());

        System.out.println(sortedEmployees);
    }
}
