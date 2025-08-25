package remaining_topics.Networking.Downloading_File_Using_Channels;

import java.io.*;
import java.net.*;
import java.nio.channels.*;

public class FileDownloader {
    public static void main(String[] args) {
        String fileName     = "file.zip"; // Name of file to download
        String urlToGetFrom = "http://www.mywebsite.com/"; // Base URL
        String pathToSaveTo = "C:\\Users\\user\\"; // Destination folder

        try (
                // Step 1: Open a ReadableByteChannel from the URL stream
                ReadableByteChannel rbc = Channels.newChannel(new URL(urlToGetFrom + fileName).openStream());
                // Step 2: Open a FileChannel to write to our local destination
                FileOutputStream fos = new FileOutputStream(pathToSaveTo + fileName);
                FileChannel fileChannel = fos.getChannel()
        ) {
            // Step 3: Transfer data from the ReadableByteChannel to the FileChannel
            fileChannel.transferFrom(rbc, 0, Long.MAX_VALUE);

            System.out.println("File downloaded successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("Output directory not found.");
        } catch (MalformedURLException e) {
            System.err.println("URL is malformed.");
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}
