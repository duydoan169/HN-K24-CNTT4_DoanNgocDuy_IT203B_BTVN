public class PhysicalProduct extends Product{
    private int weight;

    public PhysicalProduct(String id, String name, double price, int weight) {
        super(id, name, price);
        this.weight = weight;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weight: " + weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
