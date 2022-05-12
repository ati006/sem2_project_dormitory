package model;

public class Bedroom extends Room {
    private int roomNumber;
    private string bedroomType;

    public Bedroom (int roomID, String roomType, String description){
        this.roomID = roomID;
        this.description = description;
    }

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}