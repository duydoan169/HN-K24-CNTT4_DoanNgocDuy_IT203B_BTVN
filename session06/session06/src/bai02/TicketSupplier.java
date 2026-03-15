package bai02;

public class TicketSupplier  implements Runnable{
    TicketPool roomA;
    TicketPool roomB;
    int supplyCount;
    int interval;
    int rounds;

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run(){
        for (int i=0; i<rounds; i++){
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            roomA.addTickets(supplyCount);
            roomB.addTickets(supplyCount);

            System.out.println("Nhà cung cấp: Đã thêm "+supplyCount+" vé vào phòng A");
            System.out.println("Nhà cung cấp: Đã thêm "+supplyCount+" vé vào phòng A");
        }
    }
}
