package christmas.view;

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

    public void printEventBenefit(int month, int date) {
        System.out.printf("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", month, date);
    }

    public void printError(String message) {
        System.out.println(ERROR + message);
    }
}
