package com.ameliatuttle;

import java.util.ArrayList;
import java.util.List;

// Represent a single day in the calander and manage its events
public class Day {
    private int dayNumber;
    private List<Event> events;

    // This method initializes the day with its number
    public Day(int dayNumber) {
        this.dayNumber = dayNumber;
        this.events = new ArrayList<>();
    }

    // Add an event to a day
    public void addEvent(Event event) {
        events.add(event);
    }

    // See if a day has an event
    public boolean hasEvents() {
        return !events.isEmpty();
    }

    // Get the list of events
    public List<Event> getEvents() {
        return events;
    }

    // Display the events
    public void displayEvents() {
        System.out.println("Events for day " + dayNumber + ":");
        for (Event event : events) {
            System.out.println("- " + event.getDescription());
        }
    }

    // Get the day number
    public int getDayNumber() {
        return dayNumber;
    }
}
