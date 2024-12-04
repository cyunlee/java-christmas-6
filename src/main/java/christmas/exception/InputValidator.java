package christmas.exception;

import java.util.regex.Pattern;

public class InputValidator {
    private final static String INPUT_INVALID_ERROR = "입력 값은 빈 값이 될 수 없습니다. 다시 입력해주세요.";
    private final static String DAY_RANGE_INVALID_ERROR = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final static String ORDER_QUANTITY_INVALID_ERROR = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public void validateOrder(String input) {
        checkIsQuantityValid(input);
    }

    private void checkIsQuantityValid(String input) {
        String regex = "^\\d+$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ORDER_QUANTITY_INVALID_ERROR);
        }
    }

    public void validateDayRange(String input) {
        checkIsDayValid(input);
    }

    private void checkIsDayValid(String input) {
        String regex = "^\\d+$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(DAY_RANGE_INVALID_ERROR);
        }
    }

    public void validateInput(String input) {
        checkIsInputValid(input);
    }

    private void checkIsInputValid(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_INVALID_ERROR);
        }
    }
}