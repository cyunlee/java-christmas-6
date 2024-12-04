package christmas.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputParser {
    public int parseDay(String input) {
        return Integer.parseInt(input);
    }

    public Map<String, String> parseInput(String input) {
        Map<String, String> parsedInput = new HashMap<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            List<String> newOrder = Arrays.asList(order.split("-"));
            parsedInput.put(newOrder.get(0), newOrder.get(1));
        }
        return parsedInput;
    }

    public Map<String, Integer> parseOrders(String input) {
        Map<String, Integer> newOrders = new HashMap<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            List<String> newOrder = Arrays.asList(order.split("-"));
            newOrders.put(newOrder.get(0), Integer.parseInt(newOrder.get(1)));
        }
        return newOrders;
    }

}
