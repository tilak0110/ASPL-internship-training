package remaining_topics.Fluent_InterFace;

import java.util.ArrayList;
import java.util.List;

public class Validator<T> {
    private final T target;
    private final List<String> errors = new ArrayList<>();

    private Validator(T target) {
        this.target = target;
    }

    public static <T> Validator<T> of(T target) {
        return new Validator<>(target);
    }

    public Validator<T> require(boolean condition, String message) {
        if (!condition) errors.add(message);
        return this;
    }

    public void validateOrThrow() {
        if (!errors.isEmpty()) {
            throw new IllegalStateException(String.join("; ", errors));
        }
    }

    public static void main(String[] args) {
        Person p = new Person().withFirstName("Tilak");
        Validator.of(p)
                .require(p.whoAreYou().contains("Tilak"), "First name missing")
                .require(p.whoAreYou().contains("SAHU"), "Last name missing")
                .validateOrThrow();
    }
}

//Fluent Validator Utility
//Chain checks and then trigger validation.
//Use case: Input validation, business rule enforcement.

/*
* 1️. Class Purpose:
*   - fluent way without stopping at the first failure instead of ollect all errors and throw them together at the end.
* 2. Code Flow
*   - target → keeps a reference to what we’re validating.
*   - errors → keeps all failed validation messages.
* 3. Private Constructor:
*   - Private so that users must use Validator.of(...) to create an instance (ensures cleaner syntax).
* 4. Static Factory Method
*   - Generic method so you can use it with any type (Person, Order, User, etc.).
*   - Validator.of(p) creates the validator for p.
* 5. Fluent Require Method
*   - Checks a condition.
*   - If false, adds an error message to errors.
*   - Returns this so you can chain multiple .require() calls.
* 6. Validation Execution
*   - If any errors were added, joins them with ; and throws an exception.
*   - If no errors, method simply ends → validation passed.
*
*
 */