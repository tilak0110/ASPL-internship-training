public class StringBufferExample {
    public static void main(String[] args) {
        // Creating a StringBuffer object
        StringBuffer sb = new StringBuffer("Java");

        //  append() - Adds text to the end
        sb.append(" Programming");
        System.out.println("After append(): " + sb); // Java Programming

        //  insert() - Inserts text at a specified position
        sb.insert(5, "Language ");
        System.out.println("After insert(): " + sb); // Java Language Programming

        //  replace() - Replaces characters in a specific range
        sb.replace(5, 13, "Core");
        System.out.println("After replace(): " + sb); // Java Core Programming

        //  delete() - Deletes characters in a specified range
        sb.delete(5, 10);
        System.out.println("After delete(): " + sb); // Java Programming

        //  reverse() - Reverses the string
        sb.reverse();
        System.out.println("After reverse(): " + sb); // gnimmargorP avaJ

        // Reset to original for further operations
        sb.reverse();

        //  capacity() - Returns the buffer's current capacity
        System.out.println("Capacity: " + sb.capacity());

        //  length() - Returns the number of characters
        System.out.println("Length: " + sb.length());

        // charAt() - Gets a character at a specific index
        System.out.println("Character at index 5: " + sb.charAt(5));

        //  setCharAt() - Changes a character at a specific index
        sb.setCharAt(5, 'X');
        System.out.println("After setCharAt(): " + sb);

        //  ensureCapacity() - Ensures a minimum capacity
        sb.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity(50): " + sb.capacity());

        //  substring() - Extracts part of the string
        System.out.println("Substring(5, 10): " + sb.substring(5, 10));
    }
}
