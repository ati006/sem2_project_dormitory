package model;

import java.sql.*;


//Bedroom class, inherit from Room

public class Bedroom extends Room {
    private int roomNumber;
    private String bedroomType;

    public Bedroom (int roomID, String description, int roomNumber, String bedroomType){
        super(roomID, description);
        this.roomNumber = roomNumber;
        this.bedroomType = bedroomType;
    }

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBedroomType() {
		return bedroomType;
	}

	public void setBedroomType(String bedroomType) {
		this.bedroomType = bedroomType;
	}
	
	//needed for the request, used to get all the parameters to String type
		public String toQuery() {
			return Integer.toString(roomNumber) + "," + bedroomType ;
		}
	
	//second constructor, used for the sql requests
	
	public Bedroom(ResultSet rs) throws SQLException {
		super(rs.getInt("roomID"), rs.getString("description"));
		this.roomNumber = rs.getInt("RoomNumber");
		this.bedroomType = rs.getString("bedroomType");
	}
	
}