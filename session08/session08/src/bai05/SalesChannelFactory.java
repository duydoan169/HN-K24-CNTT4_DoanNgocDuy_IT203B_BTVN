package bai05;

public interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod();
    NotificationService createNotificationService();
    String getChannelName();
}
