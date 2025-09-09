package com.suraj.ai.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfiguration {

	@Bean("ollamaChatClient")
	ChatClient ollamaChatClient(OllamaChatModel chatModel) {
		return ChatClient.builder(chatModel).build();
	}

	@Bean("geminiChatClient")
	ChatClient geminiChatClient(OpenAiChatModel openAiChatModel) {
		return ChatClient.builder(openAiChatModel).build();
	}
	

}
