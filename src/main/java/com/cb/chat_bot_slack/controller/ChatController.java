package com.cb.chat_bot_slack.controller;


import com.cb.chat_bot_slack.entity.User;
import com.cb.chat_bot_slack.modal.ChatBotRequest;
import com.cb.chat_bot_slack.modal.ChatBotResponse;
import com.cb.chat_bot_slack.service.UserService;
import com.cb.chat_bot_slack.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080/")
public class ChatController {


    @Autowired
    private ChatServiceImpl chatService;


    @PostMapping("/chat-bot")
    public Mono<ChatBotResponse> createOrderDetails( @RequestBody ChatBotRequest chatBotRequest) {
        return chatService.chatBotAction(chatBotRequest);
    }

}
