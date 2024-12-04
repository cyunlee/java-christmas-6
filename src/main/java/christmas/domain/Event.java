package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Event {
    private final LocalDate startDate = LocalDate.of(2023,12,1);
    private final LocalDate christmasDate = LocalDate.of(2023,12,25);
    private final LocalDate endDate = LocalDate.of(2023,12,31);
    private final List<Integer> specialDate = Arrays.asList(3, 10, 17, 24, 25, 31);
   private LocalDate reservedDate;
   private int day;
   private int dayValue;

   public Event(int day) {
       getReservedDate(day);
       getDayOfWeek(reservedDate);
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

    public int discountedByChristmasEvent(int totalPrice) {
        int discountAmount = 1000 + 100 * (day - 1);
        return totalPrice - discountAmount;
    }

    public int discountedByWeekdayEvent(int totalPrice, int numberOfWeekdayMenu) {
        if (dayValue==7 || dayValue == 1 || dayValue == 2 || dayValue == 3 || dayValue == 4) {
            return totalPrice - numberOfWeekdayMenu * 2023;
        }
        return totalPrice;
    }

    public int discountedByWeekendEvent(int totalPrice, int numberOfMainMenu) {
        if (dayValue==5 || dayValue==6) {
            return totalPrice - numberOfMainMenu * 2023;
        }
        return totalPrice;
    }

    public int discountedBySpecialEvent(int totalPrice) {
        if (specialDate.contains(day)) {
            return totalPrice - 1000;
        }
        return totalPrice;
    }

    public boolean isGivingEventOK(int totalPrice) {
        if (totalPrice >= 120000) {
            return true;
        }
        return false;
    }
}
