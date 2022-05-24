
import java.sql.*;
import Gfx.Display;
import databaselayer.DBConnection;
import state.*;
import utils.Handler;


public class Main {
    public static void main(String[] args) {
    	
        Handler handler = new Handler(500, 500);
        handler.setDisplay(new Display(handler));
        State.changeState(new DashboardState(handler),handler);
		String query = "INSERT INTO Student VALUES (Kieran, Charpentier, 0101010101, 01010101012);";
		Statement statement;
		try {
			statement = DBConnection.getInstance().getDBcon().createStatement();
			statement.executeUpdate(query);
			ResultSet rs = statement.executeQuery("SELECT * FROM Student");
			while(rs.next()){
				  System.out.println("First Name: " + rs.getString("LastName"));
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }
}