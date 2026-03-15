package bai06;

import java.util.List;
import java.util.Random;

public class BookingCounter implements Runnable {
    String name;
    List<TicketPool> pools;
    boolean running = true;
    boolean paused = false;

    Random random = new Random();

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    public void stop() {
        running = false;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    @Override
    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            if (paused) {
                try {
                    Thread.sleep(500);
                } catch (Exception ignored) {}
                continue;
            }

            TicketPool pool = pools.get(random.nextInt(pools.size()));

            Ticket ticket = pool.sellTicket();

            if (ticket != null) {

                System.out.println(name + " bán vé " + ticket.getId());

            }

            try {
                Thread.sleep(500);
            } catch (Exception ignored) {}
        }
    }
}
