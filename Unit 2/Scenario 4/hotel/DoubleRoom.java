package hotel;

public class DoubleRoom extends Room {

    public DoubleRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, "Double", pricePerNight);
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Double Room Details:");
        super.displayRoomInfo();
    }
}
