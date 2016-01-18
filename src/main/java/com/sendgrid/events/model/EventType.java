package com.sendgrid.events.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author szagriichuk.
 */
public enum EventType {
    PROCESSED("Processed"),
    DROPPED("Dropped"),
    DELIVERED("Delivered"),
    DEFERRED("Deferred"),
    BOUNCE("Bounce"),
    OPEN("Open"),
    CLICK("Click"),
    SPAMREPORT("Spam Report"),
    UNSUBSCRIBE("Unsubscribe"),
    GROUP_UNSUBSCRIBE("Group Unsubscribe"),
    GROUP_RESUBSCRIBE("Group Resubscribe");

    public String event;

    EventType(String event) {
        this.event = event;
    }

    @JsonValue
    public void setEvent(String event) {
        this.event = event;
    }
}

