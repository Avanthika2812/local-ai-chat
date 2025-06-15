package com.localai.llamachatbot.controller;

import com.localai.llamachatbot.model.ChatModels.*;
import com.localai.llamachatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {
    
    private final ChatService chatService;
    
    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "LLaMA 2 Chat Bot");
        model.addAttribute("ollamaStatus", chatService.isOllamaAvailable());
        return "index";
    }
    
    @PostMapping("/api/chat")
    @ResponseBody
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        if (request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            ChatResponse errorResponse = new ChatResponse();
            errorResponse.setResponse("Please provide a message");
            errorResponse.setSuccess(false);
            return ResponseEntity.badRequest().body(errorResponse);
        }
        
        ChatResponse response = chatService.generateResponse(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/api/health")
    @ResponseBody
    public ResponseEntity<String> health() {
        boolean isAvailable = chatService.isOllamaAvailable();
        if (isAvailable) {
            return ResponseEntity.ok("Ollama is running and LLaMA 2 is available");
        } else {
            return ResponseEntity.serviceUnavailable()
                .body("Ollama is not available. Please ensure Ollama is running with LLaMA 2 model");
        }
    }
}