package ru.snm.misc.jdk10_builder;

/**
 * @author sine-loco
 */

public class Body {
    private final BodyFirst first;
    private final String second;


    public Body( BodyFirst first, String second ) {
        this.first = first;
        this.second = second;
    }

    public BodyFirst getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
