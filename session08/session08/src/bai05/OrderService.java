package bai05;

public class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();

        System.out.println("Bạn đã chọn kênh " + factory.getChannelName());
    }

    public void processOrder(String product, double price, int quantity) {
        double total = price * quantity;
        double discountAmount = discount.applyDiscount(total);
        double finalAmount = total - discountAmount;

        System.out.println("Áp dụng " + discount.getDescription() + ": " + discountAmount);
        payment.pay(finalAmount);
        notification.notifySuccess("Đơn hàng thành công");
    }
}
