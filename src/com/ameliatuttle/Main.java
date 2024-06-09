package com.ameliatuttle;

import java.util.Scanner;
import java.time.LocalDate;

// This class houses the main functionality of the code and calls other classes/methods
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();

        // Get the current date so that the current calendar can be displayed
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();

        // Main program loop
        while (true) {
            // Automatically show the current month's calendar
            System.out.println("\n " + currentMonth + "/" + currentYear);
            planner.displayCalendar(currentMonth, currentYear);

            // Display choices for user and get their answer
            System.out.println("1. Add event");
            System.out.println("2. Display planner");
            System.out.println("3. Display events for a day");
            System.out.println("4. Display calendar");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Call the corresponding function based on what the user said
            if (choice == 1) {
                System.out.println("Enter day (1-30):");
                int day = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter event description:");
                String description = scanner.nextLine();
                planner.addEvent(day, description);
            } else if (choice == 2) {
                planner.displayPlanner();
            } else if (choice == 3) {
                System.out.println("Enter day (1-30):");
                int day = scanner.nextInt();
                planner.displayDayEvents(day);
            } else if (choice == 4) {
                System.out.println("Enter month (1-12):");
                int month = scanner.nextInt();
                System.out.println("Enter year:");
                int year = scanner.nextInt();
                planner.displayCalendar(month, year);
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
