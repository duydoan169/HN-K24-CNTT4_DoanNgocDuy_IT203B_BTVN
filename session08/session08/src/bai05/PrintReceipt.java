package bai05;

public class PrintReceipt implements NotificationService {
    @Override
    public void notifySuccess(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}