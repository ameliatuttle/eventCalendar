package com.ameliatuttle;

import java.util.List;

public class Calendar {

    // Check if a given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Return the number of days in month. Either 30, 31, 28, or 29
    public static int numberDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    // Computes the offset of the first day of the month to find what day of the week the 1st is
    public static int computeOffset(int month, int year) {
        int daysSinceGregorianStart = 1; // Start at 1 so that it ends up being the day we want not the day before.

        // Days since the start of the gregorian calendar
        for (int iYear = 1753; iYear < year; iYear++) {
            daysSinceGregorianStart += isLeapYear(iYear) ? 366 : 365;
        }

        // Add the days for each month leading up to the given month
        for (int iMonth = 1; iMonth < month; iMonth++) {
            daysSinceGregorianStart += numberDaysInMonth(iMonth, year);
        }

        // Return the day of the week th month starts on
        return daysSinceGregorianStart % 7;
    }

    // Display the calendar for the given month
    public static void displayCalendar(int month, int year, List<Day> days) {
        int dow = computeOffset(month, year);
        int numDays = numberDaysInMonth(month, year);
        displayTable(dow, numDays, days);
    }

    // This method sets up the calendar table so it is human friendly
    private static void displayTable(int dow, int numDays, List<Day> days) {
        System.out.println("  Su  Mo  Tu  We  Th  Fr  Sa");

        for (int indent = 0; indent < dow; indent++) {
            System.out.print("    ");
        }

        final List<Day> finalDays = days;
        // Print with an * if there is an event
        for (int dom = 1; dom <= numDays; dom++) {
            int finalDom = dom;
            boolean hasEvent = finalDays.stream().anyMatch(day -> day.getDayNumber() == finalDom && day.hasEvents());
            System.out.print(String.format("%4d%s", dom, hasEvent ? "*" : ""));
            if ((dow + dom) % 7 == 0) {
                System.out.println();
            }
        }

        // Print line if the last day isn't a Saturday
        if ((dow + numDays) % 7 != 0) {
            System.out.println();
        }
    }
}
