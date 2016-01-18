package com.sendgrid.events.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author szagriichuk.
 */
public class WebHookEvents {
    private List<WebHookEvent> events = new ArrayList<>();

    public WebHookEvents(WebHookEvent[] events) {
        Collections.addAll(this.events, events);
    }

    public WebHookEvents(List<WebHookEvent> events) {
        this.events.addAll(events);
    }

    public List<WebHookEvent> getEvents() {
        return events;
    }

    public void setEvents(List<WebHookEvent> events) {
        this.events = events;
    }
}
