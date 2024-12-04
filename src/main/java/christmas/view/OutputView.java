package christmas.view;

import christmas.domain.Order;
import christmas.domain.Orders;
import java.util.List;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printWelcomePrompt() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printExpectingDatePrompt() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printOrderPrompt() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printOrders(Orders orders) {
        System.out.println("<주문 메뉴>");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void printEventBenefitPrompt(int day) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", day);
        System.out.println();
    }

    public void printEventBenefits(int totalPrice, List<Integer> discounts, String eventBadge) {
        int christmasDiscount = discounts.get(0);
        int weekdayDiscount = discounts.get(1);
        int weekendDiscount = discounts.get(2);
        int specialDiscount = discounts.get(3);
        int givingDiscount = discounts.get(4);
        int totalDiscount = discounts.stream().reduce(0, Integer::sum);

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", totalPrice));
        System.out.println("\n<증정 메뉴>");
        printGivenMenu(givingDiscount);
        System.out.println("\n<혜택 내역>");
        printEventDiscount(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, givingDiscount);
        System.out.println("\n<총혜택 금액>");
        printTotalDiscount(discounts);
        System.out.println("\n<할인 후 예상 결제 금액>");
        printTotalMoney(totalPrice, discounts, givingDiscount);
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }

    private void printGivenMenu(int givingDiscount) {
        if (givingDiscount != 0) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    private void printEventDiscount(int christmasDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount, int givingDiscount) {
        if (christmasDiscount !=0) {
            System.out.println("크리스마스 디데이 할인: " + String.format("-%,d원", christmasDiscount));
        }
        if (weekdayDiscount != 0) {
            System.out.println("평일 할인: " + String.format("-%,d원", weekdayDiscount));
        }
        if (weekendDiscount != 0) {
            System.out.println("주말 할인: " + String.format("-%,d원", weekendDiscount));
        }
        if (specialDiscount != 0) {
            System.out.println("특별 할인: " + String.format("-%,d원", specialDiscount));
        }
        if (givingDiscount != 0) {
            System.out.println("증정 이벤트: " + String.format("-%,d원", givingDiscount));
        }
    }

    private void printTotalDiscount(List<Integer> discounts) {
        int totalDiscount = discounts.stream().reduce(0, Integer::sum);
        if (totalDiscount != 0) {
            System.out.println(String.format("-%,d원", totalDiscount));
            return;
        }
        System.out.println("0원");
    }

    private void printTotalMoney(int totalPrice, List<Integer> discounts, int givingDiscount) {
        int totalDiscounts = discounts.stream().reduce(0, Integer::sum);
        int totalMoney = totalPrice - totalDiscounts;
        if (givingDiscount != 0) {
            totalMoney += 25000;
        }
        System.out.println(String.format("%,d원", totalMoney));
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}
