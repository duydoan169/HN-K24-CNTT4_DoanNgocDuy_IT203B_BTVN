package bai02;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    String roomName;
    List<Ticket> tickets;
    int nextId;

    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= totalTickets; i++) {
            String id = roomName + " - " + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }

        nextId = totalTickets + 1;
    }

    public synchronized Ticket sellTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", nextId++);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public int getRemainingTickets() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) count++;
        }
        return count;
    }
}