package com.localai.llamachatbot.model;

public class ChatModels {
    
    public static class ChatRequest {
        private String message;
        private String model = "llama2";
        private double temperature = 0.7;
        
        // Constructors
        public ChatRequest() {}
        
        public ChatRequest(String message) {
            this.message = message;
        }
        
        // Getters and Setters
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }
        
        public double getTemperature() { return temperature; }
        public void setTemperature(double temperature) { this.temperature = temperature; }
    }
    
    public static class ChatResponse {
        private String response;
        private String model;
        private long timestamp;
        private boolean success = true;
        
        // Constructors
        public ChatResponse() {
            this.timestamp = System.currentTimeMillis();
        }
        
        public ChatResponse(String response, String model) {
            this();
            this.response = response;
            this.model = model;
        }
        
        // Getters and Setters
        public String getResponse() { return response; }
        public void setResponse(String response) { this.response = response; }
        
        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }
        
        public long getTimestamp() { return timestamp; }
        public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
        
        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
    }
}