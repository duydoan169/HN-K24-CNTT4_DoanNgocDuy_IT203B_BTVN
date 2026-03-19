package bai05;

public interface DiscountStrategy {
    double applyDiscount(double total);
    String getDescription();
}
