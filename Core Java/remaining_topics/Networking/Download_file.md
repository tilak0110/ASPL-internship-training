## Downloading a File Using Channels.
1. Why Use Channels?
- NIO (Non-blocking I/O) ReadableByteChannel + FileChannel can transfer data directly, often faster than reading byte-by-byte.
- Less CPU overhead in copying between buffers — more efficient for large files.
- Cleaner, shorter code.

2. Basic Idea
- Open a URL stream to the file.
- Wrap it in a ReadableByteChannel.
- Create a FileChannel for the destination file.
- Use transferFrom() to copy the data in one operation.
- 