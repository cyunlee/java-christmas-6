package christmas.exception;

public class InputValidator {
    private final static String INPUT_INVALID_ERROR = "입력 값은 빈 값이 될 수 없습니다. 다시 입력해주세요.";

    public void validateInput(String input) {
        checkIsInputValid(input);
    }

    private void checkIsInputValid(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_INVALID_ERROR);
        }
    }
}