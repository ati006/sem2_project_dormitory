package controlLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import databaselayer.DBConnection;
import model.Bedroom;


public class BedroomCtr {
	private ArrayList<Bedroom> bedrooms;
	private static BedroomCtr instance;

	public BedroomCtr() {
		readBedrooms();
	}
	//select everything from the bedroom table
	public void readBedrooms() {
		bedrooms = new ArrayList<Bedroom>();
		String query = "SELECT * FROM Bedroom";
		try {
			ResultSet response = DBConnection.getInstance().select(query);
			while(response.next()){
				bedrooms.add(new Bedroom(response));
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static BedroomCtr getInstance(){
		  if(instance == null) instance = new BedroomCtr();
		  return instance;
		}
	public ArrayList<Bedroom> getBedrooms(){
		return bedrooms;
	}
	

}
