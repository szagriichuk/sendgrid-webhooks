package com.sendgrid.events;

/**
 * @author szagriichuk.
 */
final class Preconditions {
    private Preconditions() {
    }

    static <T> T checkNotNull(T val) {
        if (val == null)
            throw new NullPointerException("The input value is null.");
        return val;
    }
}
