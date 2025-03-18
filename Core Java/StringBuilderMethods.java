public class StringBuilderMethods {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");

        //  Append (Concatenation)
        sb.append(" Programming");
        System.out.println("After append: " + sb);

        // Insert
        sb.insert(5, "is Awesome ");
        System.out.println("After insert: " + sb);

        //  Replace
        sb.replace(5, 15, "is Fun");
        System.out.println("After replace: " + sb);

        //  Delete
        sb.delete(5, 8);
        System.out.println("After delete: " + sb);

        //  Reverse
        sb.reverse();
        System.out.println("After reverse: " + sb);

        //  Check Capacity
        System.out.println("Capacity: " + sb.capacity());
    }
}
