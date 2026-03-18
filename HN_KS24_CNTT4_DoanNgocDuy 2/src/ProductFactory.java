import java.util.Objects;

public class ProductFactory {
    public static Product createProduct(String type, String id, String name, double price, int weightSize){
        if (Objects.equals(type, "Physical")){
            return new PhysicalProduct(id, name, price, weightSize);
        }else if (Objects.equals(type, "Digital")){
            return new DigitalProduct(id, name, price, weightSize);
        }
        return null;
    }
}
