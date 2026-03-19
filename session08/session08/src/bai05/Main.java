package bai05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh bán hàng:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");
        System.out.print("Chọn: ");

        int choice = sc.nextInt();
        SalesChannelFactory factory = null;

        switch (choice) {
            case 1 -> factory = new WebsiteFactory();
            case 2 -> factory = new MobileAppFactory();
            case 3 -> factory = new POSFactory();
        }

        OrderService orderService = new OrderService(factory);

        if (choice == 1) {
            orderService.processOrder("Laptop", 15_000_000, 1);
        } else if (choice == 2) {
            orderService.processOrder("Điện thoại", 10_000_000, 1);
        }
    }
}
