package bai01;

import java.util.Random;

public class BookingCounter implements Runnable{
    String counterName;
    TicketPool roomA;
    TicketPool roomB;
    int soldCount;

    Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.soldCount = 0;
    }

    @Override
    public void run(){
        while (roomA.getRemainingTickets() > 0 || roomB.getRemainingTickets() > 0){
            Ticket ticket = null;
            if (random.nextBoolean()){
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }
            if (ticket != null){
                soldCount++;
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(counterName + " kết thúc bán vé");
    }
    public int getSoldCount(){
        return soldCount;
    }
}