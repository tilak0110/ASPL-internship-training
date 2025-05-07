package java9features.processApi;

public class Process_API_Test {
    public static void main(String[] args) {
        /*
        soo utill java 8  , communicating with processor / os / machine is very difficult
        we need to write complex native code and have to use 3rd party jar files
        so
        to resolve this  complexity  , jdk 9 introduced several enhancement to process API
        with the help of which we can communicate with any proceesor very easily
        */


        ProcessHandle ph = ProcessHandle.current() ;
        ProcessHandle.Info info = ph.info();
        System.out.println("Complete process information");
        System.out.println( info);
        System.out.println(info.user().get());
        System.out.println(info.command().get());
        System.out.println(info.startInstant().get());
    }
}
