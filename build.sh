#!/bin/bash

echo "🔨 Building LLaMA Chat Bot Application..."

# Clean and build the Maven project
echo "📦 Building with Maven..."
mvn clean package -DskipTests

# Check if build was successful
if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    echo "🚀 You can now run the application with:"
    echo "   java -jar target/llama-chatbot-1.0.0.jar"
    echo "   OR"
    echo "   docker-compose up"
else
    echo "❌ Build failed!"
    exit 1
fi