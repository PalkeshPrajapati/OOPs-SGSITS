package hotelrooms;

public class Room {
    protected int roomNumber;
    protected String roomType;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public void bookRoom() {
        System.out.println("Room " + roomNumber + " of type " + roomType + " has been booked.");
    }

    public void checkout() {
        System.out.println("Room " + roomNumber + " has been checked out.");
    }
}
