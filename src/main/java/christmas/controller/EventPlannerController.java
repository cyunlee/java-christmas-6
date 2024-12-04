package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = requireInput();

    }

    private String requireInput() {
        outputView.printPrompt();
        return inputView.readInput();
    }
}
