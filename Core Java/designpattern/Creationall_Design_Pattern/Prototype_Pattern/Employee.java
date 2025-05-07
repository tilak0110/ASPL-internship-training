package designpattern.Creationall_Design_Pattern.Prototype_Pattern;

class Employee implements Prototype {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("Tilak", "Developer");
        Employee copy = original.clone();
    }
}