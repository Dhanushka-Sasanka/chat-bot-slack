package com.cb.chat_bot_slack.service.impl;


import com.cb.chat_bot_slack.modal.ChatBotRequest;
import com.cb.chat_bot_slack.modal.ChatBotResponse;
import com.cb.chat_bot_slack.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<ChatBotResponse> chatBotAction(ChatBotRequest chatBotRequest) {
        return (Mono<ChatBotResponse>) webClient.post()
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(chatBotRequest), ChatBotRequest.class)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    return Mono.just(new Exception("Bad Request"));
                })
                .onStatus(HttpStatusCode::is5xxServerError, response -> {
                    return Mono.just(new Exception("Server Error"));
                })
                .toEntity(ChatBotResponse.class)
                .subscribe(responseEntity -> {
                    System.out.println("Status: " + responseEntity.getStatusCode().value());
                    System.out.println("Location URI: " + responseEntity.getHeaders().getLocation().toString());
                    System.out.println("Created New Employee : " + responseEntity.getBody());
                });
    }
}
