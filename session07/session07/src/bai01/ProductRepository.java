package bai01;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public void save(Product product) {
        products.add(product);
        System.out.println("Đã thêm sản phẩm " + product.getProductId());
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Product findById(String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }
}