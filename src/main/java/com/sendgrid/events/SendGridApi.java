package com.sendgrid.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.events.model.EventType;
import com.sendgrid.events.model.WebHookEvent;
import com.sendgrid.events.model.WebHookEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.sendgrid.events.Preconditions.checkNotNull;


/**
 * @author szagriichuk.
 */
public class SendGridApi {

    private static final Logger LOG = LoggerFactory.getLogger(SendGridApi.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public WebHookEvents readAll(String data) {
        return parse(checkNotNull(data));
    }

    public WebHookEvent readFirst(String data) {
        WebHookEvent event = null;
        WebHookEvents events = parse(checkNotNull(data));
        if (events != null) {
            event = events.getEvents().get(0);
        }
        return event;
    }

    public WebHookEvents filterBy(WebHookEvents data, EventType type) {
        checkNotNull(data);
        List<WebHookEvent> events = new ArrayList<>();
        for (WebHookEvent event : data.getEvents()) {
            if (type.event.toLowerCase().equals(event.getEvent().toLowerCase())) {
                events.add(event);
            }
        }
        return new WebHookEvents(events);
    }

    private WebHookEvents parse(String data) {
        WebHookEvent[] events;
        try {
            events = mapper.readValue(data, WebHookEvent[].class);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
        return new WebHookEvents(events);
    }
}
