package remaining_topics.Fluent_InterFace;

//mutable fluent interface example
public class Person {
    private String firstName;
    private String lastName;

    public Person withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String whoAreYou() {
        return "I am " + firstName + " " + lastName;
    }

    public static void main(String[] args) {
        Person p = new Person()
                .withFirstName("Tilak")
                .withLastName("Raj");

//  its not thread safe
//        p.withFirstName("Tilak");     // state changes
//        p.withLastName("Sahu");       // state changes again


        System.out.println(p.whoAreYou());
    }
}

/*
* The key idea of a fluent interface: instead of void, return the current object (this).
* This allows method chaining
* Mutable object = an object whose internal state (fields) can change after creation.
 */