package christmas.domain;

public class Order {
    private String name;
    private int quantity;
    private String type;
    private int price;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
