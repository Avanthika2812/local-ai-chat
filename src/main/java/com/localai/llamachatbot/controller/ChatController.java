
package com.localai.llamachatbot.controller;

import com.localai.llamachatbot.model.ChatModels.ChatRequest;
import com.localai.llamachatbot.model.ChatModels.ChatResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        String prompt = request.getMessage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> ollamaRequest = new HashMap<>();
        ollamaRequest.put("model", "llama2");
        ollamaRequest.put("prompt", prompt);
        ollamaRequest.put("stream", false);

        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(ollamaRequest, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    "http://localhost:11434/api/generate",
                    httpEntity,
                    Map.class);

            String aiResponse = response.getBody().get("response").toString();

            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setSuccess(true);
            chatResponse.setResponse(aiResponse);
            return ResponseEntity.ok(chatResponse);

        } catch (Exception e) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setSuccess(false);
            chatResponse.setResponse("Failed to connect to Ollama: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(chatResponse);
        }
    }

    @GetMapping("/api/health")
    public ResponseEntity<String> health() {
        try {
            ResponseEntity<Map> response = restTemplate.getForEntity("http://localhost:11434/api/tags", Map.class);
            return ResponseEntity.ok("Ollama is running and LLaMA 2 is available");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Ollama is not available. Please ensure it's running with LLaMA 2 model.");
        }
    }
}
