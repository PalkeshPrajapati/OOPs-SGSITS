package hotelSystem;

public class Suite extends Room {

    public Suite(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void bookRoom() throws OverbookingException {
        if (isBooked) {
            throw new OverbookingException("Suite room " + roomNumber + " is already booked.");
        }
        isBooked = true;
        System.out.println("Suite room " + roomNumber + " has been booked.");
    }
}
