package bai05;

import java.util.Random;

public class BookingCounter implements Runnable {
    String counterName;
    TicketPool[] pools;

    public BookingCounter(String counterName, TicketPool[] pools) {
        this.counterName = counterName;
        this.pools = pools;
    }

    Random random = new Random();

    @Override
    public void run(){
        while (true){
            try {
                boolean vip = random.nextBoolean();
                TicketPool pool = pools[random.nextInt(pools.length)];
                Ticket ticket = pool.holdTicket(counterName, vip);

                if (ticket != null){
                    Thread.sleep(3000);
                    pool.sellHeldTicket(ticket, counterName);
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
