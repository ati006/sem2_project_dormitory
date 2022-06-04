package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Booking {
	private int bookingID;
    private Date startDate;

	public Booking(int bookingID, Date startDate) {
		this.bookingID = bookingID;
		this.startDate = startDate;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	//needed for the request, used to get all the parameters to String type
	public String toQuery() {
		return "'"+Integer.toString(bookingID)+"'"+","+"'"+startDate.toString()+"'";
	}
	
	//second constructor for the sql requests 
	
	public Booking(ResultSet rs) throws SQLException {
		this.bookingID = rs.getInt("bookingID");
		this.startDate = rs.getDate("StartDate");
	}

}
