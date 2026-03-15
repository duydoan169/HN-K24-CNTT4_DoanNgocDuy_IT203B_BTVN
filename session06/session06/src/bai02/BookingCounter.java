package bai02;

import java.util.Random;

public class BookingCounter implements Runnable {
    String counterName;
    TicketPool roomA;
    TicketPool roomB;
    int soldCount;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    Random random = new Random();

    @Override
    public void run() {
        while (true) {
            Ticket ticket;
            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }
            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getSoldCount() {
        return soldCount;
    }
}