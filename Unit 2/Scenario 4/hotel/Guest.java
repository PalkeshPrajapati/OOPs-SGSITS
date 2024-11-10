package hotel;

public class Guest {
    private String name;
    private String guestID;
    private String contactInfo;

    public Guest(String name, String guestID, String contactInfo) {
        this.name = name;
        this.guestID = guestID;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void displayGuestInfo() {
        System.out.println("Guest Name: " + name);
        System.out.println("Guest ID: " + guestID);
        System.out.println("Contact Info: " + contactInfo);
    }
}
