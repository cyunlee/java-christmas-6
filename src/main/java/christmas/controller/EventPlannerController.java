package christmas.controller;

import christmas.domain.EventPlanner;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EventPlannerController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printWelcomePrompt();
        int day = requireDay();
        Orders orders = placeAnOrder(requireOrder());
        int totalPrice = processPayment(orders);
        int numberOfDessertMenu = orders.getNumberOfDessertMenu();
        int numberOfMainMenu = orders.getNumberOfMainMenu();
        List<Integer> discounts = processDiscountEvent(day, totalPrice, numberOfDessertMenu, numberOfMainMenu);
        String eventBadge = processEventBadge(day, totalPrice, numberOfDessertMenu, numberOfMainMenu);
        showOrders(day, orders);
        showEventBenefits(totalPrice, discounts, eventBadge);
    }

    private Orders placeAnOrder(Map<String, Integer> order) {
        Orders orders = new Orders();
        for (Entry<String, Integer> entry : order.entrySet()) {
            Order generatedOrder = new Order(entry.getKey(), entry.getValue());
            orders.addOrder(generatedOrder);
        }
        return orders;
    }

    private int processPayment(Orders orders) {
        return orders.getTotalPrice();
    }

    private List<Integer> processDiscountEvent(int day, int totalPrice, int numberOfDessertMenu, int numberOfMainMenu) {
        EventPlanner eventPlanner = new EventPlanner(day, totalPrice);
        List<Integer> discounts;

        int christmasDiscount = 0;
        int weekdayDiscount = 0;
        int weekendDiscount = 0;
        int specialDiscount = 0;
        int givingDiscount = 0;
        if (eventPlanner.isChristmasEventOK()) {
            christmasDiscount = eventPlanner.discountedByChristmasEvent();
        }
        if (eventPlanner.isOtherEventsOK()) {
            weekdayDiscount = eventPlanner.discountedByWeekdayEvent(numberOfDessertMenu);
            weekendDiscount = eventPlanner.discountedByWeekendEvent(numberOfMainMenu);
            specialDiscount = eventPlanner.discountedBySpecialEvent();
            givingDiscount = eventPlanner.discountedByGivingEvent();
        }

        discounts = List.of(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, givingDiscount);
        return discounts;
    }

    private String processEventBadge(int day, int totalPrice, int numberOfDessertMenu, int numberOfMainMenu) {
        EventPlanner eventPlanner = new EventPlanner(day, totalPrice);
        int discountAmount = eventPlanner.calculateTotalEventDiscount(numberOfDessertMenu, numberOfMainMenu);
        if (discountAmount >= 20000) {
            return "산타";
        }
        if (discountAmount >= 10000) {
            return "트리";
        }
        if (discountAmount >= 5000) {
            return "별";
        }
        return "없음";
    }

    private int requireDay() {
        outputView.printExpectingDatePrompt();
        return inputView.requireDay();
    }

    private Map<String, Integer> requireOrder() {
        outputView.printOrderPrompt();
        return inputView.requireOrder();
    }

    private void showOrders(int day, Orders orders) {
        outputView.printEventBenefitPrompt(day);
        outputView.printOrders(orders);
    }

    private void showEventBenefits(int totalPrice, List<Integer> discounts, String eventBadge) {
        outputView.printEventBenefits(totalPrice, discounts, eventBadge);
    }



}
