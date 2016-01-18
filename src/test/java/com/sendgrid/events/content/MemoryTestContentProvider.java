package com.sendgrid.events.content;

/**
 * @author szagriichuk.
 */
public class MemoryTestContentProvider implements TestContentProvider {
    @Override
    public String getContent() {
        return "[{\n" +
                "    \"email\":\"example@test.com\",\n" +
                "    \"timestamp\":1453115815,\n" +
                "    \"smtp-id\":\"\\u003c14c5d75ce93.dfd.64b469@ismtpd-555\\u003e\",\n" +
                "    \"event\":\"processed\",\n" +
                "    \"category\":\"cat facts\",\n" +
                "    \"sg_event_id\":\"uJIc_-9y2Fk5tSFwwkLqcQ==\",\n" +
                "    \"sg_message_id\":\"14c5d75ce93.dfd.64b469.filter0001.16648.5515E0B88.0\"\n" +
                "  }]";
    }
}
