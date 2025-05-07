package java9features.Try_With_Resource_Enhancement;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("outputfile.txt");
        try(fos){
            fos.write("this is written by tilak".getBytes());
            System.out.println("String written in the file successfully");
        } catch (Exception e) {
            e.printStackTrace();
  /*before java 9 we need to close the resources explicitly but after java 9 this is not necessary to close the resource
  * java 9 try with resource automatically close all the resources weather its a network connection
  * or any database connection ...so the finally block is no more needed  for clossing recsources*/
        }finally {
            fos.close();
        }
    }
}
