package smartdevices;

public class SecurityCamera extends SmartDevice implements BatteryPowered {
    private int batteryLevel;

    public SecurityCamera(String deviceName) {
        super(deviceName);
        this.batteryLevel = 100; // Default battery level
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Security feed activated.");
    }

    @Override
    public void scheduleAutomation() {
        System.out.println("Scheduling automation for " + getDeviceName() + " to record at 8 PM.");
    }

    @Override
    public void checkBatteryLevel() {
        System.out.println(getDeviceName() + " battery level is " + batteryLevel + "%.");
    }

    public void rechargeBattery() {
        batteryLevel = 100;
        System.out.println(getDeviceName() + " battery recharged to " + batteryLevel + "%.");
    }
}
