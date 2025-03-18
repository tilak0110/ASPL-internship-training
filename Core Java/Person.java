public class Person {
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person person= new Person();
        person.name="Mahendra";
        person.age=48;

        System.out.println(person);
    }

}
