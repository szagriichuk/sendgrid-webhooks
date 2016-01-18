package com.sendgrid.events.content;

/**
 * @author szagriichuk.
 */
public class NullTestContentProvider implements TestContentProvider {
    @Override
    public String getContent() {
        return null;
    }
}
