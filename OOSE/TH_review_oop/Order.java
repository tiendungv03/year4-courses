package TH_review_oop;

import java.util.*;

public class Order {
    Map<Product, Integer> orderItems = new HashMap<>();

    public void addProduct(Product p, int qty) {
        if (qty <= p.quantity) {
            orderItems.put(p, qty);
            p.quantity -= qty; // trừ tồn kho
        } else {
            System.out.println("Không đủ số lượng cho sản phẩm: " + p.name);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> e : orderItems.entrySet()) {
            total += e.getKey().price * e.getValue();
        }
        return total;
    }
}
