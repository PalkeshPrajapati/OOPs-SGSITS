package hotelrooms;

public class Suite extends Room implements RoomService, LaundryService {
    public Suite(int roomNumber) {
        super(roomNumber, "Suite");
    }

    @Override
    public void bookRoom() {
        super.bookRoom(); // Call the base class method
        System.out.println("Suite amenities and complimentary services included.");
    }

    @Override
    public void requestRoomService() {
        System.out.println("Room service requested for Suite " + roomNumber + ".");
    }

    @Override
    public void requestLaundryService() {
        System.out.println("Laundry service requested for Suite " + roomNumber + ".");
    }
}
