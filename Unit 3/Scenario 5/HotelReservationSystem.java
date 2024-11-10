import hotelrooms.*;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create instances of different room types
        Room standardRoom = new StandardRoom(101);
        Room deluxeRoom = new DeluxeRoom(102);
        Room suite = new Suite(201);
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an action:\n1. Book Room\n2. Check Out\n3. Exit");
            int action = scanner.nextInt();
            
            if (action == 3) {
                exit = true;
                break;
            }
            
            System.out.println("Choose room type:\n1. Standard Room\n2. Deluxe Room\n3. Suite");
            int roomChoice = scanner.nextInt();
            
            Room room = switch (roomChoice) {
                case 1 -> standardRoom;
                case 2 -> deluxeRoom;
                case 3 -> suite;
                default -> null;
            };
            
            if (room == null) {
                System.out.println("Invalid room choice.");
                continue;
            }

            switch (action) {
                case 1 -> room.bookRoom();
                case 2 -> room.checkout();
                default -> System.out.println("Invalid action choice.");
            }
            System.out.println("-----------------------------------------\n");
        }
        
        scanner.close();
    }
}
