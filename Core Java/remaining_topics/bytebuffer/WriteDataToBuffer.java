package remaining_topics.bytebuffer;

import java.nio.ByteBuffer;

public class WriteDataToBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte) 65);
        buffer.put((byte) 66);

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get() + " ");
        }

    }
}
