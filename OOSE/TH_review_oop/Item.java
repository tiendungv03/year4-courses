package TH_review_oop;


public class Item {
    int id;
    String name;
    double price;
    String description;

    public Item(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public void updateDescription(String newDesc) {
        this.description = newDesc;
    }

    @Override
    public String toString() {
        return id + " - " + name + " | Giá: " + price + " VNĐ"+" | Mô tả: " + description;
    }
}
