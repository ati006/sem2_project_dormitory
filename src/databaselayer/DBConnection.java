package databaselayer;

import java.sql.*;


public class DBConnection {   
	//Constants used to get access to the database
	
    
    //private String  userName = ";user=sa;encrypt=true;trustServerCertificate=true";
    //private String password = ";password=secret2022*";
   
    private Connection con;
    private static final String serverAddress = "localhost";
    private static final int serverPort= 1433;
    private static String userName = "sa";
    private static String password = "secret2022*";
    private static final String dbName = "HCHouse";
    private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    // an instance of the class is generated
    private static DBConnection  instance = null;
    private DBConnection() {

    	String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=false", 
                serverAddress, serverPort, dbName, userName, password);
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(connectionString);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Could not connect to database " + dbName + "@" + serverAddress + ":" + serverPort + " as user " + userName + " using password **");
            System.out.println("Connection string was: " + connectionString.substring(0, connectionString.length() - password.length()) + "....");
            e.printStackTrace();
        }

    }
    public void startTransaction() throws SQLException {
        con.setAutoCommit(false);
    }

    public void commitTransaction() throws SQLException {
        con.commit();
        con.setAutoCommit(true);
    }

    public void rollbackTransaction() throws SQLException {
        con.rollback();
        con.setAutoCommit(true);
    }
    public int executeUpdate(String sql) throws SQLException {
        System.out.println("DBConnection, Updating: " + sql);
        int res = -1;
        try (Statement s = con.createStatement()){
            res = s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return res;
    }
    public void disconnect() {
        	try {
        		con.close();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
    }
public int executeInsertWithIdentity(String sql) throws SQLException  {
        System.out.println("DBConnection, Inserting: " + sql);
        int res = -1;
        try (Statement s = con.createStatement()) {
            res = s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if(res > 0) {
                ResultSet rs = s.getGeneratedKeys();
                rs.next();
                res = rs.getInt(1);
            }
            //s.close(); -- the try block does this for us now

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return res;
    }
    
		
    //getConnection: returns the singleton instance of the DB connection
    public Connection getConnection()
    {
       return con;
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
    public ResultSet select(String query) throws SQLException {
    	return con.createStatement().executeQuery(query);
    }
    public void executeDelete(String query) throws SQLException {
			con.createStatement().execute(query);
    }

}//end DbConnection
