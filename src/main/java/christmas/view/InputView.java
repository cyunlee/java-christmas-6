package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InputValidator;
import christmas.util.InputParser;
import java.util.Map;
import java.util.Map.Entry;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public int requireDay() {
        try {
            String input = Console.readLine();
            inputValidator.validateInput(input);
            inputValidator.validateDayRange(input);
            return inputParser.parseDay(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return requireDay();
        }

    }

    public Map<String, Integer> requireOrder() {
        try {
            String input = Console.readLine();
            inputValidator.validateInput(input);
            Map<String, String> parsedInput = inputParser.parseInput(input);
            for (Entry<String, String> entry : parsedInput.entrySet()) {
                inputValidator.validateOrder(entry.getValue());
            }
            return inputParser.parseOrders(input);

        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return requireOrder();
        }
    }
}