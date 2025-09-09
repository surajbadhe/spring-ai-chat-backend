package com.suraj.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class OllamaChatController {

	@Qualifier("ollamaChatClient")
	private final ChatClient ollamaChatClient;
	
	
	/**
	 * Endpoint for Ollama (Non-streaming)
	 * @param message
	 * @return
	 */
	@GetMapping("/ollama/chat")
	public String ollamaChat(@RequestParam String message) {
		return ollamaChatClient.prompt().user(message).call().content();
	}


	/**
	 * New Streaming Endpoint for Ollama
	 * @param message
	 * @return
	 */
	@GetMapping(value = "/ollama/stream/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> ollamaStreamChat(@RequestParam String message) {
		return ollamaChatClient.prompt().user(message).stream().content();
	}

}
