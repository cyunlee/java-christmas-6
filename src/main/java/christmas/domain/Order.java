package christmas.domain;

public class Order {
    private String name;
    private int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public boolean isOrderDessert() {
        Menu menu = Menu.findMenu(name);
        if(menu.getType().equals("디저트")) {
            return true;
        }
        return false;
    }

    public boolean isOrderMain() {
        Menu menu = Menu.findMenu(name);
        if(menu.getType().equals("메인")) {
            return true;
        }
        return false;
    }

    public boolean isOrderDrink() {
        Menu menu = Menu.findMenu(name);
        if(menu.getType().equals("음료")) {
            return true;
        }
        return false;
    }

    public int calculatePrice() {
        Menu menu = Menu.findMenu(name);
        return quantity * menu.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", name, quantity);
    }
}
