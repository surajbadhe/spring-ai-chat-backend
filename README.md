# 🌟 spring-ai-chat-backend

A modern Spring Boot backend for AI-powered chat using Google Gemini and Ollama models. This project provides RESTful endpoints for text and image chat, supporting both streaming and non-streaming responses. Easily integrate with your own frontend or use the provided React app!

---
## 🚀 Features

- Chat with Google Gemini and Ollama models
- Streaming and non-streaming chat endpoints
- Image processing with Gemini
- Simple web frontend (`src/main/resources/static/index.html`)
- Easily configurable via `application.properties`
- **Frontend React App available!**

---

## 🖥️ Frontend Application

A dedicated React frontend is available to consume both streaming and normal responses from this backend.

- **GitHub:** [spring-ai-frontend](https://github.com/surajbadhe/spring-ai-frontend)
- **Tech:** React, Tailwind CSS, Axios
- **Features:**
    - Chat UI for Gemini and Ollama
    - Streaming and non-streaming support

<p align="center">
  <img src="https://github.com/surajbadhe/spring-ai-frontend/blob/main/public/demo.jpg" alt="Spring AI Frontend Demo" width="700"/>
</p>

---

## 🛠️ Prerequisites

- Java 21+
- Maven
- Ollama server (for Ollama endpoints)
- Google API Key (for Gemini endpoints)

---

## ⚡ Setup
**Clone the repository:**

```sh
   git clone https://github.com/yourusername/spring-ai-chat-backend.git
   cd spring-ai-chat-backend
```

**Configure API keys:**	
- Set your Google API key in your environment:

```sh
     export GOOGLE_API_KEY=your_google_api_key
```
- Or update `src/main/resources/application.properties` directly.

**Start Ollama server (if using Ollama):**
   
- Download and run Ollama from [https://ollama.com/](https://ollama.com/).

**Build and run the application:**

```sh
   ./mvnw spring-boot:run
```

### API Endpoints

### Gemini

- **Non-streaming chat:**  
  `GET /gemini/chat?message=your_message`

- **Streaming chat:**  
  `GET /gemini/stream/chat?message=your_message`  
  (Response is Server-Sent Events)

- **Image processing:**  
  `POST /gemini/chat/image`  
  Form-data: `message` (text), `image` (PNG file)

### Ollama

- **Non-streaming chat:**  
  `GET /ollama/chat?message=your_message`

- **Streaming chat:**  
  `GET /ollama/stream/chat?message=your_message`  
  (Response is Server-Sent Events)

⚙️ Configuration

	Edit `src/main/resources/application.properties` to change model, base URLs, or API keys.

Example:

```
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.model=llama3.2:3b
spring.ai.openai.api-key=${GOOGLE_API_KEY}
spring.ai.openai.chat.options.model=gemini-2.0-flash
```

📁 Project Structure

- `src/main/java/com/suraj/ai/controller/` — REST controllers
- `src/main/java/com/suraj/ai/configuration/` — Bean configuration
- `src/main/resources/static/` — Web frontend
- `src/main/resources/application.properties` — App config
