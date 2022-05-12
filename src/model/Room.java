package model;

public class Room {
    private int roomID;
    private String description;

    public Room() {
        this();
    }

    public Room(int roomID, String description) {
        this(roomID, description);
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


    public void createRoom() {
        System.out.println("Enter description");
        String varDescription = System.in();

        int varID = getLastID() + 1;

        Room(varID, varDescription);

    }
}