package hotelrooms;

public class StandardRoom extends Room implements RoomService {
    public StandardRoom(int roomNumber) {
        super(roomNumber, "Standard Room");
    }

    @Override
    public void bookRoom() {
        super.bookRoom(); // Call the base class method
        System.out.println("Standard room amenities included.");
    }

    @Override
    public void requestRoomService() {
        System.out.println("Room service requested for Standard Room " + roomNumber + ".");
    }
}
