# 🤖 Local AI Chat - LLaMA 2 with Ollama

A beautiful, fast, and privacy-focused web application for chatting with LLaMA 2 models locally using Ollama. No cloud dependencies, no data sharing - everything runs on your machine.

![Local AI Chat Screenshot](https://via.placeholder.com/800x400/667eea/ffffff?text=Local+AI+Chat+Interface)

## ✨ Features

- 🚀 **Real-time Chat Interface** - Smooth, responsive messaging experience
- 🎨 **Modern UI Design** - Glassmorphism design with beautiful gradients
- 🔧 **Customizable Prompts** - System prompts with quick presets
- 🤖 **Multiple Models** - Support for LLaMA 2 variants (7B, 13B, 70B)
- 🔒 **Complete Privacy** - All processing happens locally
- ⚡ **Low Latency** - Fast responses without cloud delays
- 📱 **Responsive Design** - Works on desktop and mobile
- 🎛️ **Advanced Settings** - Temperature control, model selection

## 🚀 Quick Start

### Prerequisites

- Modern web browser (Chrome, Firefox, Safari, Edge)
- [Ollama](https://ollama.ai) installed on your system

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/YOUR_USERNAME/local-ai-chat.git
   cd local-ai-chat
   ```

2. **Install and start Ollama:**
   ```bash
   # Install Ollama (visit ollama.ai for platform-specific instructions)
   
   # Pull LLaMA 2 model
   ollama pull llama2
   
   # Start Ollama server
   ollama serve
   ```

3. **Open the application:**
   - Open `index.html` in your web browser
   - Or serve it with a simple HTTP server:
     ```bash
     # Python 3
     python -m http.server 8000
     
     # Node.js (if you have http-server installed)
     npx http-server
     ```

4. **Test connection:**
   - Click "Test Connection" in the app
   - Start chatting with your local AI!

## 🎯 Usage

### Basic Chat
1. Make sure Ollama is running (`ollama serve`)
2. Open the app and test connection
3. Type your message and press Enter or click Send
4. Enjoy private, fast AI conversations!

### Customizing the AI
- **System Prompts**: Modify the AI's behavior and personality
- **Quick Presets**: Choose from Assistant, Coder, Tutor, or Creative Writer modes
- **Temperature**: Adjust creativity (0.0 = focused, 1.0 = creative)
- **Models**: Switch between different LLaMA 2 variants

 Available Models
- `llama2` - Standard 7B model (fastest)
- `llama2:13b` - 13B model (more capable)
- `llama2:70b` - 70B model (most capable, requires powerful hardware)
- `codellama` - Specialized for coding tasks

 📁 Project Structure

```
local-ai-chat/
├── index.html          # Main application file
├── README.md          # This file
├── LICENSE            # MIT License
├── .gitignore         # Git ignore rules
├── docs/              # Documentation
│   └── screenshots/   # App screenshots
└── examples/          # Example configurations
    └── prompts.md     # Sample system prompts
```

🛠️ Development

 Tech Stack
- Frontend: Pure HTML5, CSS3, JavaScript (ES6+)
- Styling: Custom CSS with glassmorphism effects
- AI Backend: Ollama REST API
- Models: LLaMA 2 family

 Key Features Implementation
- Real-time messaging: WebSocket-like experience using fetch API
- Conversation memory: Maintains context across messages
- Error handling: Graceful degradation and user feedback
- Responsive design: CSS Grid and Flexbox layouts

 Contributing
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

 🔧 Configuration

 Ollama Settings
- Default URL: `http://localhost:11434`
- Customize in the app's connection settings
- Supports custom Ollama installations

 Model Configuration
Models are automatically detected from your Ollama installation. To add more models:
```bash
ollama pull MODEL_NAME
```

 Custom System Prompts
Create your own AI personalities by modifying the system prompt. Examples:
- **Coding Assistant**: "You are an expert programmer..."
- **Creative Writer**: "You are a creative writing assistant..."
- **Research Helper**: "You are a research assistant..."

 📱 Browser Compatibility

- ✅ Chrome 80+
- ✅ Firefox 75+
- ✅ Safari 13+
- ✅ Edge 80+

 🚨 Troubleshooting

 Common Issues

"Failed to connect to Ollama"
- Ensure Ollama is running: `ollama serve`
- Check if port 11434 is available
- Verify firewall settings

"No models found"
- Pull at least one model: `ollama pull llama2`
- Wait for model download to complete
- Restart Ollama service

 Slow responses
- Check system resources (RAM/CPU)
- Consider using smaller models (7B instead of 70B)
- Close other resource-intensive applications
 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

 🙏 Acknowledgments

- [Ollama](https://ollama.ai) for the amazing local LLM runtime
- [Meta AI](https://ai.meta.com) for the LLaMA 2 models
- The open-source community for inspiration and tools

📞 Support

- 🐛 Issues: [GitHub Issues](https://github.com/Avanthika2812/local-ai-chat/issues)
- 💬 Discussions: [GitHub Discussions](https://github.com/Avanthika2812/local-ai-chat/discussions)




⭐ Star this repo if you found it helpful!

Made with ❤️ for the local AI community
