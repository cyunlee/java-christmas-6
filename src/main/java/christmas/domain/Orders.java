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

    @Override
    public Iterator<Order> iterator() {
        return Orders.iterator();
    }
}
