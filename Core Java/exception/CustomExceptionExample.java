package exception;

class CustomExceptionExample {
    static void validate(int marks) throws CustomException {
        if (marks < 40) {
            throw new CustomException("Failing grade");
        }
    }

    public static void main(String[] args) {
        try {
            validate(30);
        } catch (CustomException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}