package ru.snm.misc.jdk10_builder;

/**
 * @author sine-loco
 */

public class Full {
    private final Header header;
    private final Body body;

    public Full( Header header, Body body ) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }
}
