package bai06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationManager {
    List<TicketPool> pools = new ArrayList<>();
    List<BookingCounter> counters = new ArrayList<>();
    ExecutorService executor;

    public void startSimulation(int rooms, int ticketsPerRoom, int countersCount) {
        pools.clear();
        counters.clear();
        for (int i = 0; i < rooms; i++) {
            char roomName = (char) ('A' + i);
            pools.add(new TicketPool(String.valueOf(roomName), ticketsPerRoom));
        }
        executor = Executors.newFixedThreadPool(countersCount);

        for (int i = 1; i <= countersCount; i++) {
            BookingCounter counter = new BookingCounter("Quầy " + i, pools);
            counters.add(counter);
            executor.submit(counter);
        }
        System.out.println("Đã khởi tạo hệ thống với " + rooms + " phòng, " + (rooms * ticketsPerRoom) + " vé, " + countersCount + " quầy");
    }

    public void pauseSimulation() {
        for (BookingCounter c : counters) {
            c.pause();
        }
        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void resumeSimulation() {
        for (BookingCounter c : counters) {
            c.resume();
        }
        System.out.println("Đã tiếp tục hoạt động.");
    }

    public void addTickets(String room, int count) {
        for (TicketPool pool : pools) {
            if (pool.getRoomName().equalsIgnoreCase(room)) {
                pool.addTickets(count);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng.");
    }

    public void showStatistics() {
        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");
        int total = 0;
        for (TicketPool pool : pools) {
            int sold = pool.getSoldCount();
            System.out.println("Phòng " + pool.getRoomName() + ": Đã bán " + sold + "/" + pool.getCapacity());

            total += sold;
        }
        System.out.println("Tổng doanh thu: "+ total * 250000 + " VNĐ");
    }

    public void shutdown() {
        for (BookingCounter c : counters) {
            c.stop();
        }
        executor.shutdownNow();
        System.out.println("Đang dừng hệ thống...");
    }

    public List<TicketPool> getPools() {
        return pools;
    }
}
