package com.demospring.messageapi.services;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;

import com.demospring.messageapi.models.entity.Message;
import com.demospring.messageapi.repositories.MessageRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MessageServiceTest {
    private AutoCloseable closeable;
    @Mock
    private MessageRepository repository;
    @InjectMocks
    private MessageService messageService;
    private Message _message;
    private Message messageBD;

    @BeforeEach
    void setUp() {
        buildObjects();
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }



    @Nested
    @DisplayName("create product")
    class CreateProduct {

        @Test
        @DisplayName("it should return something if happy path")
        void itShouldReturnSomethingIfHappyPath() {

            // Given
            given(repository.save(_message)).willReturn(messageBD);

            // When
            messageService.createMessage(_message);

            // Then
            then(repository).should().save(_message);
        }
    }

    private void buildObjects() {
        _message = Message.builder()
                .msg("this is a test")
                //.from("juan")
                .to("rita")
                .timeToLifeSec(50)
                .build();
        messageBD = Message.builder()
                .id(1)
                .msg("this is a test")
                //.from("juan")
                .to("rita")
                .timeToLifeSec(50)
                .build();


    }
}