package ru.snm.misc.jdk10_builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sine-loco
 */
class FullBuilderTest {

    static final String HEADER_FIRST = "header-first";
    static final String HEADER_SECOND = "header-second";

    static final String BODY_SECOND = "body-second";


    @Test
    @DisplayName( "check Full#header" )
    void header() {
        // given
        FullBuilder subject = new FullBuilder();

        // when
        subject.header( $ -> $.first( HEADER_FIRST ).second( HEADER_SECOND ) );
        Full full = subject.build();

        // then
        assertAll( "full", () -> {
            assertAll( "header", () -> {
                assertEquals( full.getHeader().getFirst(), HEADER_FIRST );
                assertEquals( full.getHeader().getSecond(), HEADER_SECOND );
            });
            assertAll( "body", () -> assertNull( full.getBody() ) );
        } );
    }

    @Test
    @DisplayName( "check Full#body" )
    void body() {
        // FIXME make this one parametrized
        // given
        FullBuilder subject = new FullBuilder();

        // when
        subject.body( $ -> $.second( BODY_SECOND ) );
        Full full = subject.build();

        // then
        assertAll( "full", () -> {
            assertAll( "header", () -> assertNull( full.getHeader() ) );
            assertAll( "body", () -> {
                Body body = full.getBody();
                assertNull( body.getFirst() );
                assertEquals( body.getSecond(), BODY_SECOND );
            } );
        } );
    }

    @Test
    void build() {
    }
}