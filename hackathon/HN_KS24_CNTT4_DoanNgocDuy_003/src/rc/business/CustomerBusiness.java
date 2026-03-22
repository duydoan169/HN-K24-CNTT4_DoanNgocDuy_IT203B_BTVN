package rc.business;

import rc.entity.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerBusiness {
    private static CustomerBusiness instance;

    private CustomerBusiness() {
    }

    public static CustomerBusiness getInstance() {
        if(instance == null){
            instance = new CustomerBusiness();
        }
        return instance;
    }

    private List<Customer> customerList = new ArrayList<>();

    public void displayCustomers(){
        if (customerList.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }
        customerList.stream().forEach(Customer::displayData);
    }

    public void addCustomer(Customer customer){
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId().equals(customer.getCustomerId())){
                System.out.println("Mã khách hàng đã tồn tại");
                return;
            }
            if (customerList.get(i).getEmail().equals(customer.getEmail())){
                System.out.println("Email đã tồn tại");
                return;
            }
        }

        customerList.add(customer);
        System.out.println("Thêm khách hàng thành công");
    }

    public void updateCustomer(String id, Scanner sc){
        Optional<Customer> optional = customerList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
        if (optional.isEmpty()){
            System.out.println("Mã khách hàng không tồn tại");
            return;
        }

        Customer customer = optional.get();

        while(true){
            System.out.print("Nhập tên: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()){
                break;
            }else {
                customer.setCustomerName(name);
            }
        }

        while(true){
            System.out.print("Nhập email: ");
            String email = sc.nextLine().trim();
            if ((email.contains("@") && email.contains("."))){
                customer.setEmail(email);
                break;
            }else if(email.isEmpty()) {
                break;
            }
            System.out.println("Không hợp lệ");
        }

        while(true){
            System.out.print("Nhập số điện thoại: ");
            String phone = sc.nextLine().trim();
            if (phone.startsWith("0") && (phone.length() == 10 || phone.length() == 11)){
                customer.setPhone(phone);
                break;
            }else if(phone.isEmpty()) {
                break;
            }
            System.out.println("Không hợp lệ");
        }

        while(true){
            System.out.print("Nhập loại khách hàng (Cá nhân | Doanh nghiệp | Ưu đãi): ");
            String customerType = sc.nextLine().trim();
            if (customerType.equalsIgnoreCase("cá nhân") || customerType.equalsIgnoreCase("doanh nghiệp") || customerType.equalsIgnoreCase("ưu đãi")){
                customer.setCustomerType(customerType);
                break;
            }else if(customerType.isEmpty()) {
                break;
            }
            System.out.println("Không hợp lệ");
        }
        System.out.println("Sửa thông tin thành công");
    }

    public void removeCustomer(String id) {
        int oldLength = customerList.size();

        customerList = customerList.stream().filter(customer -> !customer.getCustomerId().equals(id)).collect(Collectors.toList());

        if (oldLength == customerList.size()) {
            System.out.println("Mã khách hàng không tồn tại");
        } else {
            System.out.println("Xóa khách hàng thành công");
        }
    }

    public void searchByName(String name){
        long count = customerList.stream().filter(customer -> customer.getCustomerName().equalsIgnoreCase(name)).count();
        if(count == 0){
            System.out.println("Danh sách rỗng");
        }
        customerList.stream().filter(customer -> customer.getCustomerName().equalsIgnoreCase(name)).forEach(Customer::displayData);
    }

    public void searchByType(String customerType){
        if(customerType.equalsIgnoreCase("cá nhân") || customerType.equalsIgnoreCase("doanh nghiệp") || customerType.equalsIgnoreCase("ưu đãi")){
            customerList.stream().filter(customer -> customer.getCustomerType().equalsIgnoreCase(customerType)).forEach(Customer::displayData);
        }else {
            System.out.println("Loại khách hàng không tồn tại");
        }
    }

    public void sortByNameAsc(){
        customerList.stream().sorted(Comparator.comparing(Customer::getCustomerName)).forEach(Customer::displayData);
    }
}
