import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase productList = ProductDatabase.getInstance();
        int choice = 0;
        do {
            System.out.println("---------------------- QUẢN LÝ LÝ SẢN PHẨM ----------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Nhập loại (Physical, Digital): ");
                    String type = sc.nextLine();
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Tên: "); String name = sc.nextLine();
                    System.out.print("Giá: "); double price = sc.nextDouble();
                    System.out.print(type.equals("Physical")? "Trọng lượng: " : "Dung lượng(MB): ");
                    int weightSize = sc.nextInt(); sc.nextLine();
                    Product p = ProductFactory.createProduct(type, id, name, price, weightSize);
                    productList.addProduct(p);
                    break;
                case 2:
                    productList.getAll();
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = sc.nextLine();
                    System.out.print("Loại (1-Physical, 2-Digital): ");
                    String typeU = sc.nextLine();
                    System.out.print("Tên mới: "); String nameU = sc.nextLine();
                    System.out.print("Giá mới: "); double priceU = sc.nextDouble();
                    System.out.print(typeU.equals("Physical") ? "Trọng lượng mới: " : "Dung lượng mới(MB): ");
                    int weightSizeU = sc.nextInt(); sc.nextLine();
                    Product newP = ProductFactory.createProduct(typeU, updateId, nameU, priceU, weightSizeU);
                    productList.updateProduct(updateId, newP);
                    break;
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String delId = sc.nextLine();
                    productList.removeProduct(delId);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (choice!=5);
        System.out.println("Đã thoát chương trình");
    }
}
