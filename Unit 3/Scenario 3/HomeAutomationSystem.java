import smartdevices.*;

public class HomeAutomationSystem {

    public static void main(String[] args) {
        // Create objects of different device types
        SmartDevice livingRoomLight = new Light("Living Room Light", 100);
        SmartDevice homeThermostat = new Thermostat("Home Thermostat", 22);
        SmartDevice securityCamera = new SecurityCamera("Front Door Camera");

        // Polymorphic behavior
        livingRoomLight.turnOn();
        System.err.println("");
        homeThermostat.turnOn();
        System.err.println("");
        securityCamera.turnOn();
        System.err.println("");
        
        // Schedule automation for each device
        livingRoomLight.scheduleAutomation();
        System.err.println("");
        homeThermostat.scheduleAutomation();
        System.err.println("");
        securityCamera.scheduleAutomation();
        System.err.println("");
        
        // Turn off all devices
        livingRoomLight.turnOff();
        System.err.println("");
        homeThermostat.turnOff();
        System.err.println("");
        securityCamera.turnOff();
        System.err.println("");

        // Check battery level for battery-powered devices
        BatteryPowered batteryCamera = (BatteryPowered) securityCamera;
        batteryCamera.checkBatteryLevel();
    }
}
