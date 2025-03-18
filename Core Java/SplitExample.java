public class SplitExample {
    public static void main(String[] args) {
        String data = "Java|Spring||Hibernate|";
        String[] split = data.split("\\|", -1);

        for (String s : split) {
            System.out.println("[" + s + "]");
        }
    }
}
