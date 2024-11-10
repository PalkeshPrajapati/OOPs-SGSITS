package hotelSystem;

public class Reservation {
    private Room room;

    public Reservation(Room room) {
        this.room = room;
    }

    public void bookRoom() throws OverbookingException {
        room.bookRoom();
    }

    public void checkout() {
        room.checkout();
    }
}
