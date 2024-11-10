package smartdevices;

public class Light extends SmartDevice {
    private int brightness;

    public Light(String deviceName, int brightness) {
        super(deviceName);
        this.brightness = brightness;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Adjusting brightness to " + brightness + "%.");
    }

    @Override
    public void scheduleAutomation() {
        System.out.println("Scheduling automation for " + getDeviceName() + " to turn off at 10 PM.");
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        System.out.println(getDeviceName() + " brightness set to " + brightness + "%.");
    }
}
