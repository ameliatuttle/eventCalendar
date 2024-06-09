package com.ameliatuttle;

// This class represents an event on a calendar
public class Event {
    private String description;

    // Constructor to initialize the event with a description
    public Event(String description) {
        this.description = description;
    }

    // Getter method to get description of the event
    public String getDescription() {
        return description;
    }
}
