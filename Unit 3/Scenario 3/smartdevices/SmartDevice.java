package smartdevices;

public abstract class SmartDevice {
    private String deviceName;
    private boolean status;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.status = false;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getStatus() {
        return status;
    }

    public void turnOn() {
        status = true;
        System.out.println(deviceName + " is now ON.");
    }

    public void turnOff() {
        status = false;
        System.out.println(deviceName + " is now OFF.");
    }

    // Abstract method for scheduling automation, to be implemented by subclasses
    public abstract void scheduleAutomation();
}
