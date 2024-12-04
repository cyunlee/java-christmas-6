package christmas.controller;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;
import java.util.Map.Entry;

public class EventPlannerController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        start();


    }

    private void start() {
        outputView.printWelcomePrompt();
        int day = requireDay();
        Orders orders = placeAnOrder(requireOrder());

    }

    private Orders placeAnOrder(Map<String, Integer> order) {
        Orders orders = new Orders();
        for (Entry<String, Integer> entry : order.entrySet()) {
            Order generatedOrder = new Order(entry.getKey(), entry.getValue());
            orders.addOrder(generatedOrder);
        }
        return orders;
    }

    private int requireDay() {
        outputView.printExpectingDatePrompt();
        return inputView.requireDay();
    }

    private Map<String, Integer> requireOrder() {
        outputView.printOrderPrompt();
        return inputView.requireOrder();
    }

    private void showBenefit() {
        outputView.printEventBenefit();
    }

}
