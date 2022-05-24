package databaselayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {   
	//Constants used to get access to the database
	
	//private final String  driver = "jdbc:sqlserver://localhost:1433";
    private final String  databaseName = "UCHouse";
    
    //private String  userName = ";user=sa;encrypt=true;trustServerCertificate=true";
    //private String password = ";password=secret2022*";
   
    private DatabaseMetaData dma;
    private static Connection con;
    private final String dbms = "sqlserver";
    private final String serverName = "localhost";
    private final String portNumber = "1433";
    private String userName = "sa";
    private String password = "secret2022*";
    
    // an instance of the class is generated
    private static DBConnection  instance = null;
    private DBConnection() {

        con = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

            try {
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            	try {
            		con = DriverManager.getConnection(
    						"jdbc:" + this.dbms + "://"+this.serverName + ":" + this.portNumber 
    						+ ";databaseName=UCHouse;integratedSecurity=true;encrypt=true; trustServerCertificate=false;"
    						 ,connectionProps);
            		System.out.println("Connected to database");
    			} catch (SQLException sqlE) {
					sqlE.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    }

    // the constructor is private to ensure that only one object of this class is created
    /*private DBConnection()
    {
    	String url = driver + databaseName + userName + password;

        try{
            //load of driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");
          
        }
        catch(Exception e){
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        try{
            //connection to the database
            con = DriverManager.getConnection(url);
            con.setAutoCommit(true);
            dma = con.getMetaData(); // get meta data
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }//end try
        catch(Exception e){
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor */
	   
  //closeDb: closes the connection to the database
    public static void closeConnection()
    {
       	try{
            con.close();
            instance= null;
            System.out.println("The connection is closed");
        }
         catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
         }
    }//end closeDB
		
    //getDBcon: returns the singleton instance of the DB connection
    public Connection getDBcon()
    {
       return con;
    }
    //getDBcon: returns the singleton instance of the DB connection
    public static boolean instanceIsNull()
    {
       return (instance == null);
    }    
    //this method is used to get the instance of the connection
    public static DBConnection getInstance()
    {
        if (instance == null)
        {
          instance = new DBConnection();
        }
        return instance;
    }

}//end DbConnection
