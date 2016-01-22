package com.sendgrid.events;

import com.sendgrid.events.content.FileTestContentProvider;
import com.sendgrid.events.content.MemoryTestContentProvider;
import com.sendgrid.events.content.NullTestContentProvider;
import com.sendgrid.events.content.TestContentProvider;
import com.sendgrid.events.model.EventType;
import com.sendgrid.events.model.WebHookEvent;
import com.sendgrid.events.model.WebHookEvents;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.sendgrid.events.model.EventType.*;
import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class SendGridApiTest {

    private SendGridApi sendGridApi = new SendGridApi();

    @org.junit.Test
    public void readFirstFromOneMessageTest() throws Exception {
        WebHookEvent events = readFirst(new MemoryTestContentProvider());
        assertNotNull(events);
    }

    @org.junit.Test
    public void readFirstFromListMessagesTest() throws Exception {
        WebHookEvent events = readFirst(new FileTestContentProvider());
        assertNotNull(events);
        assertEquals(events.getSg_message_id(), "14c5d75ce93.dfd.64b469.filter0001.16648.5515E0B88.0");
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void readFirstNull() throws Exception {
        readFirst(new NullTestContentProvider());
    }

    private WebHookEvent readFirst(TestContentProvider provider) {
        return sendGridApi.readFirst(provider.getContent());
    }

    @org.junit.Test
    public void readAllFromOneMessageTest() throws Exception {
        WebHookEvents events = readAll(new MemoryTestContentProvider());
        assertNotNull(events);
        assertEquals(1, events.getEvents().size());
    }

    @org.junit.Test
    public void readAllFromListMessagesTest() throws Exception {
        WebHookEvents events = readAll(new FileTestContentProvider());
        assertNotNull(events);
        assertEquals(events.getEvents().get(0).getSg_message_id(), "14c5d75ce93.dfd.64b469.filter0001.16648.5515E0B88.0");
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void readAllNull() throws Exception {
        readAll(new NullTestContentProvider());
    }

    private WebHookEvents readAll(TestContentProvider provider) {
        return sendGridApi.readAll(provider.getContent());
    }

    @Test
    public void testFilterBOUNCE() throws Exception {
        filterTest(EventType.BOUNCE);
    }

    @Test
    public void testFilterCLICK() throws Exception {
        filterTest(EventType.CLICK);
    }

    @Test
    public void testFilterDEFERRED() throws Exception {
        filterTest(EventType.DEFERRED);
    }

    @Test
    public void testFilterDELIVERED() throws Exception {
        filterTest(EventType.DELIVERED);
    }

    @Test
    public void testFilterDROPPED() throws Exception {
        filterTest(EventType.DROPPED);
    }

    @Test
    public void testFilterGROUP_RESUBSCRIBE() throws Exception {
        filterTest(EventType.GROUP_RESUBSCRIBE);
    }

    @Test
    public void testFilterGROUP_UNSUBSCRIBE() throws Exception {
        filterTest(EventType.GROUP_UNSUBSCRIBE);
    }

    @Test
    public void testFilterOPEN() throws Exception {
        filterTest(EventType.OPEN);
    }

    @Test
    public void testFilterPROCESSED() throws Exception {
        filterTest(EventType.PROCESSED);
    }

    @Test
    public void testFilterSPAMREPORT() throws Exception {
        filterTest(SPAMREPORT);
    }

    @Test
    public void testFilterUnsubscribe() throws Exception {
        filterTest(UNSUBSCRIBE);
    }

    @Test
    public void testFilterUnsubscribeSPAMREPORT() throws Exception {
        filterTest(UNSUBSCRIBE, SPAMREPORT);
    }

    @Test
    public void testFilterUnsubscribeSPAMREPORTOPEN() throws Exception {
        filterTest(UNSUBSCRIBE, SPAMREPORT, OPEN);
    }
    @Test
    public void testFilterUnsubscribeSPAMREPORTOPENDEFERRED() throws Exception {
        filterTest(UNSUBSCRIBE, SPAMREPORT, OPEN, DEFERRED);
    }

    private void filterTest(EventType... eventTypes) throws Exception {
        WebHookEvents webHookEvents = sendGridApi.filterBy(readAll(new FileTestContentProvider()), eventTypes);
        assertNotNull(webHookEvents);
        Set<String> dict = createDictionary(eventTypes);
        for (WebHookEvent webHookEvent : webHookEvents.getEvents()) {
            assertTrue(dict.contains(webHookEvent.getEvent().toLowerCase()));
        }
    }

    private Set<String> createDictionary(EventType[] types) {
        Set<String> dictionary = new HashSet<>();
        for (EventType type : types) {
            dictionary.add(type.event.toLowerCase());
        }
        return dictionary;
    }

}