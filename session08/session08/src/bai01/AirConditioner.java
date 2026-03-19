package bai01;

public class AirConditioner implements Device {
    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Làm mát.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}
