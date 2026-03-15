package bai06;

public class Ticket {
    String id;
    boolean sold;

    public Ticket(String id) {
        this.id = id;
        this.sold = false;
    }

    public String getId() {
        return id;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}