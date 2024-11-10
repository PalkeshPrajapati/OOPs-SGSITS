package smartdevices;

public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String deviceName, int temperature) {
        super(deviceName);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Setting temperature to " + temperature + "°C.");
    }

    @Override
    public void scheduleAutomation() {
        System.out.println("Scheduling automation for " + getDeviceName() + " to reduce temperature at 11 PM.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(getDeviceName() + " temperature set to " + temperature + "°C.");
    }
}
