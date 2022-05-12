package model;

public class SharedSpace extends Room {
    private String name;

    public SharedSpace (int roomID, String description){
        super(roomID, description);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
