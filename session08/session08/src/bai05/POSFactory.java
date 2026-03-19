package bai05;

public class POSFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }

    @Override
    public String getChannelName() {
        return "POS";
    }
}
