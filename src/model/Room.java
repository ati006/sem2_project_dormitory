package model;

public class Room {
    private int roomID;
    private String description;

    public Room() {
    }

    public Room(int roomID, String description) {
        this.roomID=roomID;
        this.description= description;
    }

    //GETTER AND SETTER
    public int getRoomID() {
        return roomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}