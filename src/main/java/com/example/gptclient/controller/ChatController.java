package com.example.gptclient.controller;

import com.example.gptclient.model.ChatRequest;
import com.example.gptclient.model.ChatResponse;
import com.example.gptclient.service.ChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class    ChatController {

    private final ChatService chatService;

    @Value("${api.model:gpt-4o-mini}") // Default model if none is provided
    private String defaultModel;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public ResponseEntity<ChatResponse> sendChatRequest(@RequestBody ChatRequest chatRequest) {
        // Only set default model if it's missing or empty
        if (chatRequest.getModel() == null || chatRequest.getModel().trim().isEmpty()) {
            chatRequest.setModel(defaultModel);
        }
        ChatResponse response = chatService.sendChatRequest(chatRequest);
        return ResponseEntity.ok().body(response);
    }

}
