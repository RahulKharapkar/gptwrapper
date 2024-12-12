package com.example.gptclient.service;

import com.example.gptclient.model.ChatRequest;
import com.example.gptclient.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class ChatService {

    private final WebClient webClient;

    public ChatService(@Value("${api.base.url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public ChatResponse sendChatRequest(ChatRequest chatRequest) {
        // Send the POST request and map the response to ChatResponse
        return webClient.post()
                .uri("/v1/chat/completions")
                .header("Content-Type", "application/json")
                .bodyValue(chatRequest)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();
    }
}
