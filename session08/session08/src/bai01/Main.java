package bai01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HardwareConnection connection = null;
        List<Device> devices = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị mới");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    connection = HardwareConnection.getInstance();
                    connection.connect();
                    break;

                case 2:
                    System.out.println("Chọn loại: 1. Đèn  2. Quạt  3. Điều hòa");
                    int type = sc.nextInt();

                    DeviceFactory factory = null;
                    if (type == 1) factory = new LightFactory();
                    else if (type == 2) factory = new FanFactory();
                    else if (type == 3) factory = new AirConditionerFactory();

                    if (factory != null) {
                        Device device = factory.createDevice();
                        devices.add(device);
                    }
                    break;

                case 3:
                    if (!devices.isEmpty()) {
                        System.out.println("Chọn thiết bị (1-" + devices.size() + "):");
                        int on = sc.nextInt();
                        devices.get(on - 1).turnOn();
                    }
                    break;

                case 4:
                    if (!devices.isEmpty()) {
                        System.out.println("Chọn thiết bị (1-" + devices.size() + "):");
                        int off = sc.nextInt();
                        devices.get(off - 1).turnOff();
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}
