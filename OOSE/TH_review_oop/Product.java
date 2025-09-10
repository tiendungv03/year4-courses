package TH_review_oop;

public class Product extends Item {
    String category;
    int quantity;

    public Product(int id, String name, double price, String description, String category, int quantity) {
        super(id, name, price, description);
        this.category = category;
        this.quantity = quantity;
    }

    public void applyDiscount(double percent) {
        this.price = this.price * (1 - percent / 100);
    }

    public double getInventoryValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - Giá: " +  price + " VNĐ"+  " - SL: " + quantity;
    }
}
