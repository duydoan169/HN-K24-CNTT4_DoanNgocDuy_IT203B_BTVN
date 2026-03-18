public class DigitalProduct extends Product{
    private int size;

    public DigitalProduct(String id, String name, double price, int size) {
        super(id, name, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size + "MB");
    }
}
