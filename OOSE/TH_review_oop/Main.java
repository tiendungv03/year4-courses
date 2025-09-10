package TH_review_oop;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Trà sữa Matcha", 30000, "Ngọt, béo", "Đồ uống", 20));
        products.add(new Product(2, "Bánh mì đặc biệt", 15000, "Bánh mì thịt", "Thức ăn", 30));
        products.add(new Product(3, "Cà phê muối", 25000, "Đen đá nhiều muối", "Đồ uống", 15));

        // 1) Cập nhật sản phẩm (kế thừa từ Item)
        products.get(0).updatePrice(28000);
        products.get(1).updateDescription("Bánh mì chả cá anh 5");

        // 2) Hiển thị theo giá
        System.out.println("\nDanh sách theo giá:");
        products.stream()
                .sorted(Comparator.comparingDouble(p -> p.price))
                .forEach(System.out::println);

        // 2) Hiển thị theo danh mục "Đồ uống"
        System.out.println("\nDanh sách Đồ uống:");
        products.stream()
                .filter(p -> p.category.equals("Đồ uống"))
                .forEach(System.out::println);

        // 3) Tổng giá trị tồn kho theo danh mục
        System.out.println("\nTổng giá trị tồn kho:");
        Map<String, Double> inventoryValue = new HashMap<>();
        for (Product p : products) {
            inventoryValue.put(p.category,
                    inventoryValue.getOrDefault(p.category, 0.0) + p.getInventoryValue());
        }
        inventoryValue.forEach((cat, val) -> System.out.println(cat + ": " + val + " VNĐ"));

        // 4) Giảm giá
        products.get(2).applyDiscount(10); // giảm 10% cho cà phê
        System.out.println("\nSau giảm giá: " + products.get(2));

        // 5) Đặt hàng
        Order order = new Order();
        order.addProduct(products.get(0), 2); // mua 2 trà sữa
        order.addProduct(products.get(1), 3); // mua 3 bánh mì

        System.out.println("\nTổng tiền đơn hàng: " + order.calculateTotal());
    }
}
