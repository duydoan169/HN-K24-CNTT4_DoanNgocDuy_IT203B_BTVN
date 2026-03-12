package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private String id;
    private Map<MenuItem,Integer> items=new HashMap<>();
    private OrderStatus status;
    private double discount;
    private LocalDate date;

    public Order(String id){
        this.id=id;
        this.status=OrderStatus.PENDING;
        this.date=LocalDate.now();
    }

    public void addItem(MenuItem item,int quantity){

        items.put(item,items.getOrDefault(item,0)+quantity);

    }

    public void applyDiscount(double percent){

        discount=percent;

    }

    public double calculateTotal(){

        double total=0;

        for(Map.Entry<MenuItem,Integer> entry:items.entrySet()){

            total+=entry.getKey().calculatePrice()*entry.getValue();

        }

        total=total-(total*discount/100);

        return total;
    }

    public String getId(){
        return id;
    }

    public Map<MenuItem,Integer> getItems(){
        return items;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setStatus(OrderStatus status){
        this.status=status;
    }

}