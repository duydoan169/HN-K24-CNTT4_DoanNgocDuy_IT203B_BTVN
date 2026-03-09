package bai05;

//nó sẽ bị lỗi "Cannot resolve symbol 'logActivity' nếu 2 interface trùng nhau thì ko bt compiler ko bt
// chọn phương thức nào
public class Main {
    public static void main(String[] args) {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.logActivity("System updated");
    }
}