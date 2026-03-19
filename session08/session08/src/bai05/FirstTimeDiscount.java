package bai05;

public class FirstTimeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.15;
    }

    @Override
    public String getDescription() {
        return "giảm giá 15% (lần đầu)";
    }
}
