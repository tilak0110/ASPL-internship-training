import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        //  Basic Example with Delimiters, Prefix, and Suffix
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("Apple").add("Banana").add("Cherry");
        System.out.println("Basic StringJoiner: " + sj); // Output: [Apple, Banana, Cherry]

        //  StringJoiner Without Prefix and Suffix
        StringJoiner simpleJoiner = new StringJoiner(" - ");
        simpleJoiner.add("Red").add("Green").add("Blue");
        System.out.println("Without Prefix & Suffix: " + simpleJoiner); // Output: Red - Green - Blue

        //  Checking Length of StringJoiner
        System.out.println("Length of simpleJoiner: " + simpleJoiner.length());

        //  Merging Two StringJoiners
        StringJoiner sj2 = new StringJoiner("; ", "{", "}");
        sj2.add("Mango").add("Peach");

        sj.merge(sj2);  // Merging sj2 into sj
        System.out.println("Merged StringJoiner: " + sj); // Output: [Apple, Banana, Cherry; Mango; Peach]

        //  Handling Empty StringJoiner
        StringJoiner emptyJoiner = new StringJoiner(", ", "<", ">");
        System.out.println("Empty StringJoiner: " + emptyJoiner); // Output: <>

        //  Convert StringJoiner to String
        String resultString = sj.toString();
        System.out.println("Converted to String: " + resultString);

        //  Adding Default Value When Empty
        StringJoiner sj3 = new StringJoiner(", ");
        sj3.setEmptyValue("No Elements Found");
        System.out.println("Empty StringJoiner with Default Value: " + sj3);
    }
}
