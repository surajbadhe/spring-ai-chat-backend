package com.suraj.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GeminiChatController {
	
	@Qualifier("geminiChatClient")
	private final ChatClient geminiChatClient;


	/**
	 * Endpoint for Google Gemini (Non-streaming)
	 * @param message
	 * @return
	 */
	@GetMapping("/gemini/chat")
	public String geminiChat(@RequestParam String message) {
		return geminiChatClient.prompt().user(message).call().content();
	}



	/**
	 * New Streaming Endpoint for Google Gemini
	 * @param message
	 * @return
	 */
	@GetMapping(value = "/gemini/stream/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> geminiStreamChat(@RequestParam String message) {
		return geminiChatClient.prompt().user(message).stream().content();
	}
	
	
	/**
	 * Image processing endpoint for Google Gemini
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/gemini/chat/image")
	public String geminiChatWithImageProcessing(@RequestPart("message") String message, @RequestPart("image") MultipartFile multipartFile) {
		return geminiChatClient
				.prompt()
				.user(prompt ->prompt
						.text(message)
						.media(MediaType.IMAGE_PNG, new InputStreamResource(multipartFile)))
				.call()
				.content();
	}
}
