package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlannerController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        start();


    }

    private void start() {
        outputView.printWelcomePrompt();
        int day = requireDay();
        Map<String, Integer> order = requireOrder();
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
