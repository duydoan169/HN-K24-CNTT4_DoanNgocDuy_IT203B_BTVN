package service;

import model.MenuItem;
import model.Order;

import java.time.LocalDate;
import java.util.*;

public class OrderService {

    private List<Order> orders=new ArrayList<>();

    public void createOrder(Order order){

        orders.add(order);

    }

    public double getTotalRevenue(){

        return orders.stream()
                .mapToDouble(Order::calculateTotal)
                .sum();

    }

    public double revenueByDate(LocalDate date){

        return orders.stream()
                .filter(o->o.getDate().equals(date))
                .mapToDouble(Order::calculateTotal)
                .sum();

    }

    public Map<MenuItem,Integer> bestSelling(){

        Map<MenuItem,Integer> result=new HashMap<>();

        for(Order order:orders){

            for(Map.Entry<MenuItem,Integer> entry:order.getItems().entrySet()){

                result.put(entry.getKey(),
                        result.getOrDefault(entry.getKey(),0)+entry.getValue());

            }

        }

        return result;
    }

}