package hotelSystem;

public class StandardRoom extends Room {

    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void bookRoom() throws OverbookingException {
        if (isBooked) {
            throw new OverbookingException("Standard room " + roomNumber + " is already booked.");
        }
        isBooked = true;
        System.out.println("Standard room " + roomNumber + " has been booked.");
    }
}
