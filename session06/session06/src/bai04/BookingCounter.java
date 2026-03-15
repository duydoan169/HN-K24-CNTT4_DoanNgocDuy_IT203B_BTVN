package bai04;

public class BookingCounter implements Runnable {
    String counterName;
    TicketPool roomA;
    TicketPool roomB;
    boolean reverseLock;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, boolean reverseLock) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.reverseLock = reverseLock;
    }

    public void sellCombo() {
        synchronized (roomA) {
            synchronized (roomB) {
                Ticket ticketA = roomA.getAvailableTicket();
                Ticket ticketB = roomB.getAvailableTicket();

                if (ticketA != null && ticketB != null) {
                    ticketA.setSold(true);
                    ticketB.setSold(true);

                    System.out.println(counterName + " bán combo thành công: "
                            + ticketA.getTicketId() + " & " + ticketB.getTicketId());
                } else {
                    System.out.println(counterName + " bán combo thất bại");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            sellCombo();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}