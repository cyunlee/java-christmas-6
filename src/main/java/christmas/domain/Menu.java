package christmas.domain;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    APPETIZER1("양송이수프", 6000),
    APPETIZER2("타파스", 5500),
    APPETIZER3("시저샐러드", 8000),
    MAIN1("티본스테이크", 55000),
    MAIN2("바비큐립", 54000),
    MAIN3("해산물파스타", 35000),
    MAIN4("크리스마스파스타", 25000),
    DESSERT1("초코케이크", 15000),
    DESSERT2("아이스크림", 5000),
    DRINK1("제로콜라", 3000),
    DRINK2("레드와인", 60000),
    DRINK3("샴페인", 25000);

    private final String name;
    private final int price;
    private String type;

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
        setType(name);
    }

    private void setType(String name) {
        List<String> appetizer = Arrays.asList("양송이수프", "타파스", "시저샐러드");
        List<String> main = Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타");
        List<String> dessert = Arrays.asList("초코케이크", "아이스크림");
        List<String> drink = Arrays.asList("제로콜라", "레드와인", "샴페인");

        if (appetizer.contains(name)) {
            this.type = "애피타이저";
        }
        if (main.contains(name)) {
            this.type = "메인";
        }
        if (dessert.contains(name)) {
            this.type = "디저트";
        }
        if (drink.contains(name)) {
            this.type = "음료";
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
