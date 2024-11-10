package hotel;

public class SingleRoom extends Room {

    public SingleRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, "Single", pricePerNight);
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Single Room Details:");
        super.displayRoomInfo();
    }
}
