package hotelSystem;

public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void bookRoom() throws OverbookingException {
        if (isBooked) {
            throw new OverbookingException("Deluxe room " + roomNumber + " is already booked.");
        }
        isBooked = true;
        System.out.println("Deluxe room " + roomNumber + " has been booked.");
    }
}
