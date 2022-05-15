package model;

public class Bedroom extends Room {
    private int roomNumber;
    private int bedroomType;

    public Bedroom (int roomID, String description){
        this.roomID = roomID;
        this.description = description;
    }

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getBedroomType() {
		return bedroomType;
	}

	public void setBedroomType(int bedroomType) {
		this.bedroomType = bedroomType;
	}
}