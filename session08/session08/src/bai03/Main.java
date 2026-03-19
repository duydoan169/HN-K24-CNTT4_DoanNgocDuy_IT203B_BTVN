package bai03;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(1, new LightOnCommand(light));
        remote.pressButton(1);

        remote.setCommand(2, new LightOffCommand(light));
        remote.pressButton(2);

        remote.undo();

        remote.setCommand(3, new ACSetTemperatureCommand(ac, 26));
        remote.pressButton(3);

        remote.undo();
    }
}