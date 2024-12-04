package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InputValidator;
import christmas.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public int requireDay() {
        String input = Console.readLine();
    }

    public String requireOrder() {
        String input = Console.readLine();
    }

    public String readInput() {
        try{
            String input = Console.readLine();
            inputValidator.validateInput(input);
            return inputParser.parseInput(input);
        }catch(IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return readInput();
        }
    }
}