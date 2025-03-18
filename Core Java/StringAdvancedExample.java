import java.util.StringTokenizer;

public class StringAdvancedExample {
    public static void main(String[] args) {
        //  String Literals & Object Creation
        String s1 = "Hello"; // String literal (stored in the string pool)
        String s2 = "Hello"; // Same reference from the pool
        String s3 = new String("Hello"); // Creates a new object in heap memory
        String s4 = new String("Hello").intern(); // Forces it to the string pool

        //  Comparison of References (==) vs Content (.equals())
        System.out.println("s1 == s2 : " + (s1 == s2)); // true (same pool reference)
        System.out.println("s1 == s3 : " + (s1 == s3)); // false (heap vs pool)
        System.out.println("s1 == s4 : " + (s1 == s4)); // true (interned)
        System.out.println("s1.equals(s3) : " + s1.equals(s3)); // true (same content)

        //  Checking hashCode() of Strings
        System.out.println("HashCode of s1: " + s1.hashCode());
        System.out.println("HashCode of s3: " + s3.hashCode());
        System.out.println("HashCode of s4: " + s4.hashCode()); // Same as s1

        //  String Immutability
        String immutableStr = "Java";
        immutableStr.concat(" Programming"); // Does not change original string
        System.out.println("Immutable String after concat: " + immutableStr); // Still "Java"

        // String Performance Test: String vs StringBuilder
        long startTime = System.nanoTime();
        String testStr = "";
        for (int i = 0; i < 10000; i++) {
            testStr += "A"; // New object created each time
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by String (slow): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("A"); // Modifies existing object
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder (fast): " + (endTime - startTime) + " ns");

        // Using substring() (Creates a new object)
        String fullText = "Java Programming";
        String subText = fullText.substring(5); // "Programming"
        System.out.println("Substring: " + subText);

        // Splitting a String
        String csvData = "Java,Python,C++,JavaScript";
        String[] languages = csvData.split(",");
        System.out.println("Languages:");
        for (String lang : languages) {
            System.out.println(lang);
        }

        //String Tokenizer
        StringTokenizer st = new StringTokenizer(csvData,",");
        while (st.hasMoreElements()){
            System.out.println(st.nextElement());
        }

        //  String Joiner
        String joinedString = String.join(" | ", "Spring", "Hibernate", "Microservices");
        System.out.println("Joined String: " + joinedString);
    }
}
