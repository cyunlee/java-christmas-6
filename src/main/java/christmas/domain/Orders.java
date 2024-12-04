package christmas.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orders implements Iterable<Order> {
    private List<Order> Orders = new ArrayList<>();

    public List<Order> addOrder(Order Order) {
        Orders.add(Order);
        return Orders;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Order order : Orders) {
            totalPrice += order.calculatePrice();
        }
        return totalPrice;
    }

    @Override
    public Iterator<Order> iterator() {
        return Orders.iterator();
    }
}
