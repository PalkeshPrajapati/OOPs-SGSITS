package hotelrooms;

public class DeluxeRoom extends Room implements RoomService {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber, "Deluxe Room");
    }

    @Override
    public void bookRoom() {
        super.bookRoom(); // Call the base class method
        System.out.println("Deluxe room amenities included.");
    }

    @Override
    public void requestRoomService() {
        System.out.println("Room service requested for Deluxe Room " + roomNumber + ".");
    }
}
