import java.util.*;
import java.util.stream.Collectors;

/* ======================= MAIN ======================= */
public class FastFoodManagementApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final MenuService menuService = new MenuService();
    private static final OrderService orderService = new OrderService(menuService);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n===== FAST FOOD MANAGEMENT =====");
                System.out.println("1. Menu Management");
                System.out.println("2. Order Management");
                System.out.println("3. Statistics");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> menuMenu();
                    case 2 -> orderMenu();
                    case 3 -> statisticMenu();
                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /* ================= MENU MANAGEMENT ================= */
    private static void menuMenu() {
        System.out.println("\n--- MENU MANAGEMENT ---");
        System.out.println("1. Add item");
        System.out.println("2. Show menu");
        System.out.println("3. Search by name");
        System.out.println("4. Remove item");
        System.out.print("Choose: ");

        int c = Integer.parseInt(scanner.nextLine());

        switch (c) {
            case 1 -> addMenuItem();
            case 2 -> menuService.displayMenu();
            case 3 -> {
                System.out.print("Name: ");
                menuService.searchByName(scanner.nextLine())
                        .forEach(System.out::println);
            }
            case 4 -> {
                System.out.print("Item ID: ");
                menuService.removeItem(scanner.nextLine());
            }
        }
    }

    private static void addMenuItem() {
        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Base price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        System.out.print("1. Food | 2. Drink: ");
        int type = Integer.parseInt(scanner.nextLine());

        if (type == 1) {
            menuService.addItem(new Food(id, name, price, stock));
        } else {
            System.out.print("Size (S/M/L): ");
            String size = scanner.nextLine();
            menuService.addItem(new Drink(id, name, price, stock, size));
        }
    }

    /* ================= ORDER MANAGEMENT ================= */
    private static void orderMenu() {
        System.out.println("\n--- ORDER MANAGEMENT ---");
        System.out.println("1. Create order");
        System.out.println("2. Add item to order");
        System.out.println("3. Pay order");
        System.out.print("Choose: ");

        int c = Integer.parseInt(scanner.nextLine());

        switch (c) {
            case 1 -> orderService.createOrder();
            case 2 -> {
                System.out.print("Order ID: ");
                String oid = scanner.nextLine();
                System.out.print("Menu ID: ");
                String mid = scanner.nextLine();
                System.out.print("Quantity: ");
                int qty = Integer.parseInt(scanner.nextLine());
                orderService.addItemToOrder(oid, mid, qty);
            }
            case 3 -> {
                System.out.print("Order ID: ");
                orderService.payOrder(scanner.nextLine());
            }
        }
    }

    /* ================= STATISTICS ================= */
    private static void statisticMenu() {
        System.out.println("\n--- STATISTICS ---");
        System.out.println("1. Total revenue");
        System.out.println("2. Best sellers");
        System.out.print("Choose: ");

        int c = Integer.parseInt(scanner.nextLine());

        if (c == 1) {
            System.out.println("Revenue: " + orderService.getTotalRevenue());
        } else {
            orderService.getBestSellers().forEach(System.out::println);
        }
    }
}

/* ======================= MENU ITEM ======================= */
abstract class MenuItem {
    private String id;
    private String name;
    private double basePrice;
    private int stock;

    public MenuItem(String id, String name, double basePrice, int stock) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.stock = stock;
    }

    public abstract double calculatePrice();

    public void reduceStock(int qty) {
        if (qty > stock) {
            throw new InsufficientStockException("Not enough stock for " + name);
        }
        stock -= qty;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    protected double getBasePrice() { return basePrice; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return id + " | " + name + " | Price: " + calculatePrice() + " | Stock: " + stock;
    }
}

class Food extends MenuItem {
    public Food(String id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice();
    }
}

class Drink extends MenuItem {
    private String size;

    public Drink(String id, String name, double price, int stock, String size) {
        super(id, name, price, stock);
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        return switch (size.toUpperCase()) {
            case "M" -> getBasePrice() + 5000;
            case "L" -> getBasePrice() + 10000;
            default -> getBasePrice();
        };
    }
}

/* ======================= ORDER ======================= */
enum OrderStatus {
    PENDING, PAID, CANCELLED
}

class Order {
    private String id = UUID.randomUUID().toString();
    private Map<MenuItem, Integer> items = new HashMap<>();
    private OrderStatus status = OrderStatus.PENDING;

    public void addItem(MenuItem item, int qty) {
        items.merge(item, qty, Integer::sum);
    }

    public double getTotal() {
        return items.entrySet().stream()
                .mapToDouble(e -> e.getKey().calculatePrice() * e.getValue())
                .sum();
    }

    public Map<MenuItem, Integer> getItems() { return items; }
    public String getId() { return id; }
    public OrderStatus getStatus() { return status; }
    public void pay() { status = OrderStatus.PAID; }
}

/* ======================= SERVICES ======================= */
class MenuService {
    private final List<MenuItem> menu = new ArrayList<>();

    public void addItem(MenuItem item) {
        menu.add(item);
    }

    public void displayMenu() {
        menu.forEach(System.out::println);
    }

    public Optional<MenuItem> findById(String id) {
        return menu.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    public List<MenuItem> searchByName(String name) {
        return menu.stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void removeItem(String id) {
        menu.removeIf(m -> m.getId().equals(id));
    }
}

class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private final MenuService menuService;

    public OrderService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void createOrder() {
        Order order = new Order();
        orders.add(order);
        System.out.println("Created order ID: " + order.getId());
    }

    public void addItemToOrder(String orderId, String menuId, int qty) {
        Order order = getOrder(orderId);
        MenuItem item = menuService.findById(menuId)
                .orElseThrow(() -> new InvalidOrderIdException("Menu item not found"));

        item.reduceStock(qty);
        order.addItem(item, qty);
    }

    public void payOrder(String orderId) {
        Order order = getOrder(orderId);
        order.pay();
        System.out.println("Paid: " + order.getTotal());
    }

    public double getTotalRevenue() {
        return orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.PAID)
                .mapToDouble(Order::getTotal)
                .sum();
    }

    public List<MenuItem> getBestSellers() {
        return orders.stream()
                .flatMap(o -> o.getItems().keySet().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    private Order getOrder(String id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new InvalidOrderIdException("Order not found"));
    }
}

/* ======================= EXCEPTIONS ======================= */
class InvalidOrderIdException extends RuntimeException {
    public InvalidOrderIdException(String message) {
        super(message);
    }
}

class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}