package com.demospring.messageapi.models.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    Message testMessage;
    @BeforeEach
    void setUp() {
        testMessage = new Message();
        testMessage.setId(1L);
        testMessage.setMsg("This is a test");
        testMessage.setTo("Juan");
        testMessage.setFrom("Rita");
        testMessage.setTimeToLifeSec(45);
    }

    @Test
    @DisplayName("it should create object Message if happy path")
    public void itShouldCreateObjectProduct(){
        // Given
        Message _message = new Message();
        _message.setId(1L);
        _message.setMsg("This is a test");
        _message.setFrom("Rita");
        _message.setTo("Juan");
        _message.setTimeToLifeSec(45);

        // then
        assertNotNull(_message.getId());
        assertNotNull(_message.getMsg());
        assertNotNull(_message.getFrom());
        assertNotNull(_message.getTo());
        assertNotNull(_message.getTimeToLifeSec());

        // test @Data lombok

        //reflexive: for any non-null value x, the expression x.equals(x) should return true.
        //assertTrue(_message.equals(testMessage));
        //symmetric: for any non-null values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
        //assertTrue(_message.equals(testMessage) && testMessage.equals(_message));
        //consistent: for any non-null values x and y, multiple invocations of x.equals(y) should consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
        //assertTrue(_message.equals(testMessage) && _message.equals(testMessage) && _message.equals(testMessage) && _message.equals(testMessage));
        //Null check: for any non-null value x, x.equals(null) should return false.
        assertFalse(_message.equals(null));

        //assertEquals(_message, testMessage);
        //assertEquals(_message.hashCode(), testMessage.hashCode());
        //assertEquals(_message.toString(), testMessage.toString());

        assertTrue(_message.getFrom().toString().equals("Rita"));


    }

}