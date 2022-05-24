package model;

import java.sql.*;

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
	public Bedroom(ResultSet rs) throws SQLException {
		super(rs.getInt("roomID"), rs.getString("description"));
		this.roomNumber = rs.getInt("RoomNumber");
		this.bedroomType = rs.getString("bedroomType");
	}
	
}