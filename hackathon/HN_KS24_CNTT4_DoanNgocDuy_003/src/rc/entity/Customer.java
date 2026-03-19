package rc.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    private String customerId; //C001
    private String customerName;
    private String email;
    private String phone;
    private String customerType; //uu dai, doanh nghiep, ca nhan
    private LocalDate registrationDate;

    public Customer(String customerId, String customerName, String email, String phone, String customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.registrationDate = LocalDate.now();
    }

    public Customer() {
        this.registrationDate = LocalDate.now();
    }

    public void displayData(){
        System.out.println("Id: " + customerId);
        System.out.println("Name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Type: " + customerType);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println();
    }

    public void inputData(Scanner sc){
        while(true){
            System.out.print("Nhập id (VD: C001): ");
            this.customerId = sc.nextLine().trim();
            if (this.customerId.matches("C\\d{3,}")){
                break;
            }
            System.out.println("Không hợp lệ");
        }

        while(true){
            System.out.print("Nhập tên: ");
            this.customerName = sc.nextLine().trim();
            if (!this.customerId.isEmpty()){
                break;
            }
            System.out.println("Không hợp lệ");
        }

        while(true){
            System.out.print("Nhập email: ");
            this.email = sc.nextLine().trim();
            if (this.email.contains("@") && this.email.contains(".")){
                break;
            }
            System.out.println("Không hợp lệ");
        }

        while(true){
            System.out.print("Nhập số điện thoại: ");
            this.phone = sc.nextLine().trim();
            if (this.phone.startsWith("0") && (this.phone.length() == 10 || this.phone.length() == 11)){
                break;
            }
            System.out.println("Không hợp lệ");
        }

        while(true){
            System.out.print("Nhập loại khách hàng (Cá nhân | Doanh nghiệp | Ưu đãi): ");
            this.customerType = sc.nextLine().trim();
            if (this.customerType.equalsIgnoreCase("cá nhân") || this.customerType.equalsIgnoreCase("doanh nghiệp") || this.customerType.equalsIgnoreCase("ưu đãi")){
                break;
            }
            System.out.println("Không hợp lệ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(customerId);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
