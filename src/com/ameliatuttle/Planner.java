package com.ameliatuttle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Planner {
    private List<Day> days;
    private static final String FILE_NAME = "events.txt"; // Name of file created that stores events

    // Initialize the planner
    public Planner() {
        days = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            days.add(new Day(i));
        }
        loadEvents();
    }

    // Add events to specific days based on user input
    public void addEvent(int day, String description) {
        if (day > 0 && day <= days.size()) {
            days.get(day - 1).addEvent(new Event(description));
            saveEvents();
        } else {
            System.out.println("Invalid day!");
        }
    }

    // Displays the days of the month that have an event
    public void displayPlanner() {
        for (Day day : days) {
            if (day.hasEvents()) {
                System.out.print(day.getDayNumber());
                System.out.print("*");
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    // Display events for specific days
    public void displayDayEvents(int day) {
        if (day > 0 && day <= days.size()) {
            days.get(day - 1).displayEvents();
        } else {
            System.out.println("Invalid day!");
        }
    }

    // Call to display calendar in Calendar class
    public void displayCalendar(int month, int year) {
        Calendar.displayCalendar(month, year, days);
    }

    // Load events from a file
    private void loadEvents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                int day = Integer.parseInt(parts[0]);
                String description = parts[1];
                days.get(day - 1).addEvent(new Event(description));
            }
        } catch (IOException e) {
            System.out.println("No existing events found.");
        }
    }

    // Save events to a file
    private void saveEvents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Day day : days) {
                for (Event event : day.getEvents()) {
                    writer.write(day.getDayNumber() + "," + event.getDescription());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving events.");
        }
    }
}
