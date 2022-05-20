package model;

import java.sql.Date;

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

}
