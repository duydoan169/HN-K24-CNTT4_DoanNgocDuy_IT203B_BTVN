package bai04;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    String roomName;
    List<Ticket> tickets;

    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= totalTickets; i++) {
            String id = roomName + " - " + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public Ticket getAvailableTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                return t;
            }
        }
        return null;
    }

    public int getRemainingTickets() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                count++;
            }
        }
        return count;
    }
}