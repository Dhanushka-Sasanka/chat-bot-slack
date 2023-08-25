package com.cb.chat_bot_slack.service;

import com.cb.chat_bot_slack.modal.ChatBotRequest;
import com.cb.chat_bot_slack.modal.ChatBotResponse;
import reactor.core.publisher.Mono;


public interface ChatService {

    Mono<ChatBotResponse> chatBotAction(ChatBotRequest chatBotRequest);

}
