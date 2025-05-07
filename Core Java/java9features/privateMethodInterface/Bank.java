package java9features.privateMethodInterface;

public interface Bank {

    double getBalance();

    void deposit(double amount);

    void withdrawal(double amount) ;

    default void executeTransection(String type , double amount){
        if(type.equals("WITHDRAWAL")) {
            withdrawal(amount);
            /*before java 9 we have to do this [code dublication]*/
//            System.out.println("Transaction type :"+type);
//            System.out.println("Transaction amount :"+amount);
//            System.out.println("Final Balance:"+ getBalance());
            logTransaction(type ,amount);


        }else if(type.equals("DEPOSIT")){
            deposit(amount);
            /*before java 9 we have to do this [code dublication]*/
//            System.out.println("Transaction type :"+type);
//            System.out.println("Transaction amount :"+amount);
//            System.out.println("Final Balance:"+ getBalance());

            logTransaction(type ,amount);
        }else {
            System.out.println("Transaction Failed");
        }
    }
    private void logTransaction(String type , double amount){
        /*-Aftwer java 9 we can create private methods inside interface and use it in proper way -*/
              System.out.println("Transaction type :"+type);
              System.out.println("Transaction amount :"+amount);
              System.out.println("Final Balance:"+ getBalance());


    }
}
