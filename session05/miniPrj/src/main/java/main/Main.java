package main;

import model.*;
import service.MenuService;
import service.OrderService;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        MenuService menuService=new MenuService();
        OrderService orderService=new OrderService();

        menuService.addItem(new Food("F01","Burger",30000));
        menuService.addItem(new Food("F02","Pizza",50000));
        menuService.addItem(new Drink("D01","Coca",10000,"L"));
        menuService.addItem(new Dessert("DS01","IceCream",15000));

        while(true){

            System.out.println("\n===== FAST FOOD MANAGEMENT =====");
            System.out.println("1. Show Menu");
            System.out.println("2. Create Order");
            System.out.println("3. Search Food By Name");
            System.out.println("4. Search Food By Price");
            System.out.println("5. Show Revenue");
            System.out.println("6. Best Selling Food");
            System.out.println("0. Exit");

            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    menuService.showMenu();

                    break;

                case 2:

                    System.out.println("Enter Order ID:");
                    String oid=sc.next();

                    Order order=new Order(oid);

                    while(true){

                        menuService.showMenu();

                        System.out.println("Enter Food ID (0 to finish):");
                        String id=sc.next();

                        if(id.equals("0")) break;

                        MenuItem item=menuService.findById(id);

                        if(item==null){

                            System.out.println("Food not found");

                            continue;
                        }

                        System.out.println("Quantity:");
                        int q=sc.nextInt();

                        order.addItem(item,q);

                    }

                    System.out.println("Discount (%):");
                    double d=sc.nextDouble();

                    order.applyDiscount(d);

                    orderService.createOrder(order);

                    System.out.println("Total: "+order.calculateTotal());

                    break;

                case 3:

                    System.out.println("Enter name:");

                    String name=sc.next();

                    menuService.searchByName(name)
                            .forEach(i-> System.out.println(i.getName()));

                    break;

                case 4:

                    System.out.println("Min price:");

                    double min=sc.nextDouble();

                    System.out.println("Max price:");

                    double max=sc.nextDouble();

                    menuService.searchByPrice(min,max)
                            .forEach(i-> System.out.println(i.getName()));

                    break;

                case 5:

                    System.out.println("Total revenue: "+orderService.getTotalRevenue());

                    break;

                case 6:

                    Map<MenuItem,Integer> best=orderService.bestSelling();

                    for(Map.Entry<MenuItem,Integer> entry:best.entrySet()){

                        System.out.println(entry.getKey().getName()+" : "+entry.getValue());

                    }

                    break;

                case 0:

                    return;

            }

        }

    }

}