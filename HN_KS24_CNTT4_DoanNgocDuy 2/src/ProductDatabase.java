import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> list;

    private ProductDatabase() {
        this.list = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public List<Product> getList() {
        return list;
    }

    public void addProduct(Product p) {
        if (p != null) {
            list.add(p);
        }
    }

    public void updateProduct(String id, Product p) {
        if (list.isEmpty()) {
            System.out.println("Khong hop le");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id)) {
                list.set(i, p);
                return;
            }
        }
    }

    public void removeProduct(String id) {
        if (list.isEmpty()) {
            System.out.println("Khong hop le");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id)) {
                list.remove(i);
                return;
            }
        }
    }

    public void getAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        for (Product product : list) {
            product.displayInfo();
        }
    }
}