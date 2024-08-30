package com.tech.spring_ai.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final OllamaChatModel chatModel;

    private static final String SHORT_PROMPT = " Explain in short 30 words";

    @Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/prompt")
    public Flux<String> promptResponse(@RequestParam("prompt") String message) {
        return chatModel.stream(message + SHORT_PROMPT);
    }
}
