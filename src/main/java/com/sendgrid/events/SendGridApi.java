package com.sendgrid.events;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.sendgrid.events.model.EventType;
import com.sendgrid.events.model.WebHookEvent;
import com.sendgrid.events.model.WebHookEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.sendgrid.events.Preconditions.checkNotNull;


/**
 * @author szagriichuk.
 */
public class SendGridApi {

    private static final Logger LOG = LoggerFactory.getLogger(SendGridApi.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private Optional<String> of(String data) {
        return Optional.of(data);
    }

    public WebHookEvents readAll(String data) {
        return of(checkNotNull(data)).map(a -> parse(data)).filter(a->a!=null).get();
    }

    public WebHookEvent readFirst(String data) {
        return of(checkNotNull(data)).map(a -> parse(data)).filter(a->a!=null).map(a -> a.getEvents().stream().findFirst().get()).get();
    }

    public WebHookEvents filterBy(WebHookEvents data, EventType type) {
        return new WebHookEvents(checkNotNull(data).getEvents().stream().filter(e -> type.event.toLowerCase().equals(e.getEvent().toLowerCase())).collect(Collectors.toList()));
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
