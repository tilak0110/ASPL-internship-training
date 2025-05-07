package designpattern.Creationall_Design_Pattern.singleton;

public class DatabaseConfig {
    private static DatabaseConfig instance ;
    private String connectionUrl ;

    private DatabaseConfig(){
        this.connectionUrl = "jdbc:mysql://localhost:3306/db_info";
    }

    public static synchronized DatabaseConfig getInstance(){
        if(instance==null){
            instance = new DatabaseConfig() ;
        }
        return instance ;

    }
    public  String getConnectionUrl(){
        return connectionUrl ;
    }

    //usage
    public static void main(String[] args) {
        DatabaseConfig config = DatabaseConfig.getInstance() ;
        System.out.println(config.getConnectionUrl());
    }
}
