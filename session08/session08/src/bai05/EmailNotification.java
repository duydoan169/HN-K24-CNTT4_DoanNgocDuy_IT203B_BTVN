package bai05;

public class EmailNotification implements NotificationService {
    @Override
    public void notifySuccess(String message) {
        System.out.println("Gửi email: " + message);
    }
}
