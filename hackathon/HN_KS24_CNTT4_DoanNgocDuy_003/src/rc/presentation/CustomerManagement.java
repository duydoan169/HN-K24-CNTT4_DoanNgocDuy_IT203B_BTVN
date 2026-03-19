package rc.presentation;

import rc.business.CustomerBusiness;
import rc.entity.Customer;

import java.util.Scanner;

public class CustomerManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        boolean isLooping = true;
        CustomerBusiness customerBusiness = CustomerBusiness.getInstance();
        while(isLooping){
            System.out.println("*************QUẢN LÝ KHÁCH HÀNG*************");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Cập nhật thông tin khách hàng theo mã");
            System.out.println("4. Xóa khác hàng theo mã");
            System.out.println("5. Tìm kiếm khách hàng theo tên");
            System.out.println("6. Lọc khách hàng theo loại");
            System.out.println("7. Sắp xếp theo tên tăng dần");
            System.out.println("8. thoát");
            System.out.println("********************************************");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();

            switch (choice){
                case "1":
                    customerBusiness.displayCustomers();
                    break;
                case "2":
                    String continueinput = "y";
                    while(continueinput.equalsIgnoreCase("y")){
                        Customer newCustomer = new Customer();
                        newCustomer.inputData(sc);
                        customerBusiness.addCustomer(newCustomer);
                        System.out.println("\nTiếp tục nhập? (y to continue): ");
                        continueinput = sc.nextLine().trim();
                    }
                    break;
                case "3":
                    System.out.print("Nhập id: ");
                    String updateId = sc.nextLine();
                    customerBusiness.updateCustomer(updateId, sc);
                    break;
                case "4":
                    System.out.print("Nhập id: ");
                    String removeId = sc.nextLine().trim();
                    customerBusiness.removeCustomer(removeId);
                    break;
                case "5":
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine().trim();
                    customerBusiness.searchByName(name);
                    break;
                case "6":
                    System.out.print("Nhập loại khách hàng: ");
                    String type = sc.nextLine().trim();
                    customerBusiness.searchByType(type);
                    break;
                case "7":
                    customerBusiness.sortByNameAsc();
                    break;
                case "8":
                    isLooping = false;
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }
    }
}
