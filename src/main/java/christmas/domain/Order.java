package christmas.domain;

public class Order {
    private String name;
    private int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int calculatePrice() {
        Menu menu = Menu.findMenu(name);
        return quantity * menu.getPrice();
    }

}
