package com.demospring.messageapi.models.entity;

import com.demospring.messageapi.models.dto.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageResponseTest {

    @Test
    @DisplayName("it should set and get an text")
    public void itShouldGetMessageTest(){
        MessageResponse  test = new MessageResponse();
        test.setMessage("messages");
        assertNotNull(test.getMessage());
    }

    @Test
    @DisplayName("it should set and get an text")
    public void itShouldGetMessageTestConstructor(){
        MessageResponse  test = new MessageResponse("this is a message");
        assertNotNull(test.getMessage());
    }

}
