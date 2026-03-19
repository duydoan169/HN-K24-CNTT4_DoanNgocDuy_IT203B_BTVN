package bai05;

public class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt (COD): " + amount);
    }
}
