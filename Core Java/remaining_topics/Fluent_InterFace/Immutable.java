package remaining_topics.Fluent_InterFace;

public final class Immutable {
    private final String brand;     //final = can't change after construction
    private final String color;

    private Immutable(Builder builder) {
        this.brand = builder.brand;
        this.color = builder.color;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String brand;
        private String color;

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Immutable build() {
            if (brand == null || color == null) {
                throw new IllegalStateException("brand and color are required");
            }
            return new Immutable(this);
        }
    }

    @Override
    public String toString() {
        return brand + " (" + color + ")";
    }

    public static void main(String[] args) {
        Immutable c = Immutable.builder()
                .setBrand("Nano")
                .setColor("White")
                .build();
        System.out.println(c);
    }
}

/*
*   final = once assigned in the constructor, they cannot be changed.
*   This guarantees that the state of the  object will never change after creation.
*   Private Constructor: Only Builder can call this. and This ensures all construction happens in one place (no half-constructed objects floating around).
*   Builder Class is mutable, Holds temporary data while you configure it.
*   build() Method Validates that required fields are set before creating the immutable object, Returns a new object (not the Builder itself).
 */