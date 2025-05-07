package designpattern.Creationall_Design_Pattern.singleton;

public enum Singleton {
    INSTANCE ;

    public void doSomething(){
        System.out.println("singleton using enum");
    }

    //we can use this by
    public static void main(String[] args) {
        Singleton.INSTANCE.doSomething();
    }
}


