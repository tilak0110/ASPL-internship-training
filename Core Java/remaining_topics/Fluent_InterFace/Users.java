package remaining_topics.Fluent_InterFace;

//Staged builder pattern: It forces to call methods in a specific order at compile-time.
public class Users {
    private final String username; // required
    private final String email;    // required
    private final Integer age;     // optional
    private final String phone;    // optional

    private Users(String username, String email, Integer age, String phone) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    // Step 1: Username
    public interface UsernameStep {
        EmailStep username(String username);
    }

    // Step 2: Email
    public interface EmailStep {
        OptionalStep email(String email);
    }

    // Step 3: Optional fields + Build
    public interface OptionalStep {
        OptionalStep age(int age); // optional
        OptionalStep phone(String phone); // optional
        Users build();
    }

    // Builder start
    public static UsernameStep builder() {
        return username -> email -> new OptionalStepImpl(username, email);
    }

    // Actual builder implementation for optional step
    private static class OptionalStepImpl implements OptionalStep {
        private final String username;
        private final String email;
        private Integer age;
        private String phone;

        OptionalStepImpl(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public OptionalStep age(int age) {
            this.age = age;
            return this;
        }

        public OptionalStep phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Users build() {
            return new Users(username, email, age, phone);
        }
    }

    @Override
    public String toString() {
        return "User: " + username + " | Email: " + email +
                (age != null ? " | Age: " + age : "") +
                (phone != null ? " | Phone: " + phone : "");
    }

    public static void main(String[] args) {
        Users u1 = Users.builder()
                .username("tilak")
                .email("tilak@example.com")
                .build(); // no optional fields

        Users u2 = Users.builder()
                .username("raj")
                .email("raj@example.com")
                .age(22)
                .phone("9999999999")
                .build(); // with optional fields

        System.out.println(u1);
        System.out.println(u2);
    }
}


//Staged Builder (Compile-Time Safety)
//Enforces method order so you can’t forget required fields.
//Use case: Critical configs (e.g., API clients) where you must set certain fields.

/*
*1. Final Class Fields:
*   - Only constructor can set them.
*
* 2. Private Constructor:
*   - Can’t call new Users() directly from outside, Forces creation through the builder.
*
* 3. The Stages:
*   - UsernameStep → must call .username(...) → gives you EmailStep.
*   - EmailStep → must call .email(...) → gives you BuildStep.
*   - BuildStep → can only call .build() → returns Users.
*
* 4. OptionalStage:
*   - You can call .age() or .phone() in any order
*   - Can skip them entirely
*   - Always end with .build()
*
* 5. The Builder:( chain of lambdas )
*   - username -> means: when someone calls .username(...), capture that value. Returns an EmailStep lambda.
*   - email -> captures email, returns a BuildStep lambda.
*   - () -> new Users(...) is the .build() step.
*
 */