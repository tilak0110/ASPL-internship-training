package remaining_topics.bytebuffer;

import java.nio.ByteBuffer;

public class CreateBuffer {
    public static void main(String[] args) {
        // Create heap buffer (inside JVM)
        ByteBuffer heapBuffer = ByteBuffer.allocate(5);

        // Create direct buffer (outside JVM)
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(5);

        System.out.println("Heap capacity: " + heapBuffer.capacity());
        System.out.println("Direct capacity: " + directBuffer.capacity());
    }
}
