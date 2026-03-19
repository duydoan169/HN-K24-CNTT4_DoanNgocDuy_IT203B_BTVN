package bai05;

public class WebsiteDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.1;
    }

    @Override
    public String getDescription() {
        return "giảm giá 10%";
    }
}
