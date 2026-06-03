package javaIntermediate.enums;

import java.util.Arrays;

public class DayDriver {
    public static void main(String[] args) {
        System.out.println(Day.FRIDAY);
        System.out.println(Day.SATURDAY);
        System.out.println(Day.TUESDAY);
        System.out.println(Day.valueOf("MONDAY"));
        // System.out.println(Day.valueOf("MONDAy")); // exception
        Day day = Day.SUNDAY;
        System.out.println(day.ordinal());
        System.out.println(day.name());
        System.out.println(day.name().toLowerCase());
        System.out.println(day.toString());

        System.out.println(Arrays.toString(Day.values()));
    }
}
