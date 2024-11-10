package hotelSystem;

public abstract class Room {
    protected int roomNumber;
    protected boolean isBooked;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public abstract void bookRoom() throws OverbookingException;

    public void checkout() {
        isBooked = false;
        System.out.println("Room " + roomNumber + " has been checked out.");
    }
}
