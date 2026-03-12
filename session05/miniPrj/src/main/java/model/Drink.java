package model;

public class Drink extends MenuItem {

    private String size;

    public Drink(String id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public double calculatePrice() {

        if(size.equals("L")){
            return getPrice() + 5000;
        }

        if(size.equals("M")){
            return getPrice() + 3000;
        }

        return getPrice();
    }

}