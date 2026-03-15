package bai06;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(roomName + "-" + i));
        }
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

    public synchronized int getSoldCount() {

        int count = 0;

        for (Ticket t : tickets) {
            if (t.isSold()) count++;
        }

        return count;
    }

    public int getCapacity() {
        return tickets.size();
    }

    public String getRoomName() {
        return roomName;
    }

    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(roomName + "-" + (start + i)));
        }

        System.out.println("Đã thêm " + count + " vé vào phòng " + roomName);
    }
}
