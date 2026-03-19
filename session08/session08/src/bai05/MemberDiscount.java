package bai05;

public class MemberDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.05;
    }

    @Override
    public String getDescription() {
        return "giảm giá 5% cho thành viên";
    }
}
