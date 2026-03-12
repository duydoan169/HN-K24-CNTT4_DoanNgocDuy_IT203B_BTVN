import java.util.*;
import java.util.stream.*;

public class ProductManager {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product p) throws InvalidProductException {
        if (products.stream().anyMatch(prod -> prod.getId() == p.getId())) {
            throw new InvalidProductException("ID đã tồn tại!");
        }
        products.add(p);
    }

    public void displayProducts() {
        products.forEach(System.out::println);
    }

    public void updateQuantity(int id, int newQuantity) throws InvalidProductException {
        Optional<Product> opt = products.stream().filter(p -> p.getId() == id).findFirst();
        if (opt.isPresent()) {
            opt.get().setQuantity(newQuantity);
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm với ID: " + id);
        }
    }

    public void deleteOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }
}