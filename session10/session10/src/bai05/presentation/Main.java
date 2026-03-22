package bai05.presentation;

import bai05.business.DoctorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ BÁC SĨ ===");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê theo chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> service.showDoctors();

                case 2 -> {
                    System.out.print("Mã bác sĩ: ");
                    String id = sc.nextLine();
                    System.out.print("Họ tên: ");
                    String name = sc.nextLine();
                    System.out.print("Chuyên khoa: ");
                    String spec = sc.nextLine();
                    service.addDoctor(id, name, spec);
                }

                case 3 -> service.statisticBySpecialty();

                case 4 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }

                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
