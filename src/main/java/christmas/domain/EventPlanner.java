package christmas.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EventPlanner {
    private final LocalDate startDate = LocalDate.of(2023,12,1);
    private final LocalDate christmasDate = LocalDate.of(2023,12,25);
    private final LocalDate endDate = LocalDate.of(2023,12,31);
    private final List<Integer> specialDate = Arrays.asList(3, 10, 17, 24, 25, 31);
   private LocalDate reservedDate;
   private int day;
   private int totalPrice;
   private int dayValue;

   public EventPlanner(int day, int totalPrice) {
       getReservedDate(day);
       getDayOfWeek(reservedDate);
       this.totalPrice = totalPrice;
       this.day = day;
   }

    private void getReservedDate(int day) {
        this.reservedDate = LocalDate.of(2023,12,day);
    }

    private void getDayOfWeek(LocalDate reservedDate) {
        this.dayValue = reservedDate.getDayOfWeek().getValue();
    }

    public boolean isChristmasEventOK() {
        if (reservedDate.isAfter(startDate) && reservedDate.isBefore(christmasDate)) {
            return true;
        }
        return false;
    }

    public boolean isOtherEventsOK() {
        if (reservedDate.isAfter(startDate) && reservedDate.isBefore(endDate)) {
            return true;
        }
        return false;
    }

    public int discountedByChristmasEvent() {
        return 1000 + 100 * (day - 1);
    }

    public int discountedByWeekdayEvent(int numberOfDessertMenu) {
        if (dayValue==7 || dayValue == 1 || dayValue == 2 || dayValue == 3 || dayValue == 4) {
            return numberOfDessertMenu * 2023;
        }
        return 0;
    }

    public int discountedByWeekendEvent(int numberOfMainMenu) {
        if (dayValue==5 || dayValue==6) {
            return numberOfMainMenu * 2023;
        }
        return 0;
    }

    public int discountedBySpecialEvent() {
        if (specialDate.contains(day)) {
            return 1000;
        }
        return 0;
    }

    public int discountedByGivingEvent() {
        if (totalPrice >= 120000) {
            return 25000;
        }
        return 0;
    }

    public int calculateTotalEventDiscount(int numberOfDessertMenu, int numberOfMainMenu) {
       return discountedByChristmasEvent() + discountedByWeekdayEvent(numberOfDessertMenu) + discountedByWeekendEvent(numberOfMainMenu) + discountedBySpecialEvent() + discountedByGivingEvent();
    }
}
