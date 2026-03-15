package bai06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimulationManager manager = new SimulationManager();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Tiếp tục mô phỏng");
            System.out.println("4. Thêm vé vào phòng");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();
                    System.out.print("Số vé/phòng: ");
                    int tickets = sc.nextInt();
                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();
                    manager.startSimulation(rooms, tickets, counters);
                    break;

                case 2:
                    manager.pauseSimulation();
                    break;

                case 3:
                    manager.resumeSimulation();
                    break;

                case 4:
                    System.out.print("Nhập phòng: ");
                    String room = sc.next();
                    System.out.print("Số vé thêm: ");
                    int count = sc.nextInt();
                    manager.addTickets(room, count);
                    break;

                case 5:
                    manager.showStatistics();
                    break;

                case 6:
                    new Thread(new DeadlockDetector()).start();
                    break;

                case 7:
                    manager.shutdown();
                    System.out.println("Kết thúc chương trình.");
                    return;
            }
        }
    }
}