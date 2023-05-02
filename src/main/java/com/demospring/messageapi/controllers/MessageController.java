package com.demospring.messageapi.controllers;

import com.demospring.messageapi.models.dto.MessageResponse;
import com.demospring.messageapi.models.entity.Message;
import com.demospring.messageapi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devops")
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping()
    public ResponseEntity<MessageResponse> create(@RequestBody Message message) {
        try {
            var _message = messageService.createMessage(message);
            var response = new MessageResponse(String.format("Hello, %s your message will be send", _message.getFrom()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

