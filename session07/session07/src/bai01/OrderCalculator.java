package bai01;

import java.util.Map;

public class OrderCalculator {
    public static long calculateTotal(Order order){
        long sum = 0;
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            sum += (long) (product.getPrice()*quantity);
        }
        return sum;
    }
}
