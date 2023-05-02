package com.demospring.messageapi.services;

import com.demospring.messageapi.models.entity.Message;
import com.demospring.messageapi.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message){
        return messageRepository.save(message);
    }
}
