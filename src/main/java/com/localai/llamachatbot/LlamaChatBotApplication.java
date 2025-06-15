package com.localai.llamachatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LlamaChatBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(LlamaChatBotApplication.class, args);
        System.out.println("🚀 LLaMA Chat Bot Application Started!");
        System.out.println("🌐 Open http://localhost:8080 in your browser");
    }
}