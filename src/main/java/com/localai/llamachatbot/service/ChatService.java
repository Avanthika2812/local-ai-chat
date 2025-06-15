package com.localai.llamachatbot.service;

import com.localai.llamachatbot.model.ChatModels.*;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    
    private final ChatClient chatClient;
    
    @Autowired
    public ChatService(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }
    
    public com.localai.llamachatbot.model.ChatModels.ChatResponse generateResponse(ChatRequest request) {
        try {
            // Create options for the request
            OllamaOptions options = OllamaOptions.create()
                    .withModel(request.getModel())
                    .withTemperature(request.getTemperature());
            
            // Create prompt with options
            Prompt prompt = new Prompt(request.getMessage(), options);
            
            // Get response from Ollama
            ChatResponse response = chatClient.call(prompt);
            
            // Extract the generated text
            String generatedText = response.getResult().getOutput().getContent();
            
            return new com.localai.llamachatbot.model.ChatModels.ChatResponse(
                generatedText, 
                request.getModel()
            );
            
        } catch (Exception e) {
            com.localai.llamachatbot.model.ChatModels.ChatResponse errorResponse = 
                new com.localai.llamachatbot.model.ChatModels.ChatResponse();
            errorResponse.setResponse("Error: " + e.getMessage());
            errorResponse.setSuccess(false);
            errorResponse.setModel(request.getModel());
            
            return errorResponse;
        }
    }
    
    public boolean isOllamaAvailable() {
        try {
            ChatRequest testRequest = new ChatRequest("Hello");
            com.localai.llamachatbot.model.ChatModels.ChatResponse response = generateResponse(testRequest);
            return response.isSuccess();
        } catch (Exception e) {
            return false;
        }
    }
}