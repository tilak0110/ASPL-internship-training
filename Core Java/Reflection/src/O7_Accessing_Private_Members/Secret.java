package Reflection.src.O7_Accessing_Private_Members;

class Secret {
    private String secretCode = "12345";
    private void showSecret() {
        System.out.println("The secret is: " + secretCode);
    }
}
