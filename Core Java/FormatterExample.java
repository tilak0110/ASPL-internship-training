import java.util.Formatter;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;

public class FormatterExample {
    public static void main(String[] args) {
        //  Using Formatter
        Formatter fmt = new Formatter();
        fmt.format("Name: %s, Age: %d, Salary: %.2f", "Tilak", 25, 50000.5);
        System.out.println(fmt); // Output: Name: Tilak, Age: 25, Salary: 50000.50
        fmt.close();

        //  Using System.out.printf()
        System.out.printf("Name: %s, Age: %d, Salary: %.2f%n", "Tilak", 25, 50000.5);

        // Formatting numbers and alignment
        System.out.printf("Integer: %d, Float: %.2f, Hex: %x, Octal: %o, String: %s%n",
                255, 12.3456, 255, 255, "Hello");

        // Left & Right Alignment
        System.out.printf("%10s%n", "Java");   // Right-align
        System.out.printf("%-10s%n", "Java");  // Left-align

        //  Formatting a Table
        System.out.printf("%-10s %-10s %-10s%n", "Name", "Age", "Salary");
        System.out.printf("%-10s %-10d %-10.2f%n", "Tilak", 25, 50000.5);
        System.out.printf("%-10s %-10d %-10.2f%n", "Raj", 30, 60000.75);

        // Writing formatted output to a file
        try {
            Formatter fileFormatter = new Formatter(new File("output.txt"));
            fileFormatter.format("%-10s %-10s %-10s%n", "Name", "Age", "Salary");
            fileFormatter.format("%-10s %-10d %-10.2f%n", "Tilak", 25, 50000.5);
            fileFormatter.format("%-10s %-10d %-10.2f%n", "Raj", 30, 60000.75);
            fileFormatter.close();
            System.out.println("Formatted data written to output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file.");
        }
    }
}
