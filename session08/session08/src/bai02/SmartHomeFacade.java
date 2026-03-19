package bai02;

public class SmartHomeFacade {

    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;
    private TemperatureSensor temperatureSensor;

    public SmartHomeFacade(TemperatureSensor temperatureSensor) {
        this.light = new Light();
        this.fan = new Fan();
        this.airConditioner = new AirConditioner();
        this.temperatureSensor = temperatureSensor;
    }

    public void leaveHome() {
        light.off();
        fan.off();
        airConditioner.off();
    }

    public void sleepMode() {
        light.off();
        airConditioner.setTemperature(28);
        fan.lowSpeed();
    }

    public void getCurrentTemperature() {
        if (temperatureSensor instanceof ThermometerAdapter adapter) {
            double c = adapter.getTemperatureCelsius();
            int f = adapter.getRawFahrenheit();
            System.out.printf(
                    "Nhiệt độ hiện tại: %.1f°C (chuyển đổi từ %d°F)%n",
                    c, f
            );
        } else {
            System.out.println(
                    "Nhiệt độ hiện tại: " +
                            temperatureSensor.getTemperatureCelsius() + "°C"
            );
        }
    }
}
