package bai01;

public class Ticket {
    String ticketId;
    String roomName;
    boolean isSold;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
