package com.moc.eventfinder.model.DTO.event;

import java.util.List;

public class EventResponse {
    private int count;
    private String next;
    private String previous;
    private List<Event> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Event> getResults() {
        return results;
    }
}