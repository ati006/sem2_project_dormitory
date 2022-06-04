package controlLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import databaselayer.DBConnection;
import model.Booking;


public class BookingCtr {
	private ArrayList<Booking> bookings;
	private static BookingCtr instance;
	private int lastBookingID;

	public BookingCtr() {
		readBookings();
	}
	
	//select everything from the Booking table
	
	public void readBookings() {
		bookings = new ArrayList<Booking>();
		String query = "SELECT * FROM Booking";
		try {
			ResultSet response = DBConnection.getInstance().select(query);
			while(response.next()){
				lastBookingID = bookings.size() > 0 ? bookings.get(bookings.size() - 1).getBookingID() : 0;
				bookings.add(new Booking(response));
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static BookingCtr getInstance(){
		  if(instance == null) instance = new BookingCtr();
		  return instance;
		}
	public ArrayList<Booking> getBookings(){
		return bookings;
	}
	
	//insertBooking is used to create new booking the DB
	
	public static void insertBooking(Booking b) {
		String query = "INSERT INTO Booking(BookingID, StartDate, CPR, RoomNumber) VALUES(" + b.toQuery() + ");";
		try {
			DBConnection.getInstance().executeInsertWithIdentity(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getLastBookingId() {
		return lastBookingID; 
	}
	
	

}
