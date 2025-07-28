package remaining_topics.bytebuffer;

import java.nio.ByteBuffer;

public class DirectBufferExample {
    public static void main(String[] args) {
        // Allocate a DirectByteBuffer of 10 bytes
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);

        buffer.put((byte) 100);
        buffer.flip();

        byte b = buffer.get();

        System.out.println("Byte read: " + b);
    }
}
