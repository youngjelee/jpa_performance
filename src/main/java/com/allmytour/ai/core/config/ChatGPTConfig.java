package com.allmytour.ai.core.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatGPTConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder

                .defaultSystem("You are a friendly chat bot that answers question in the voice of a Pirate")
//                .defaultOptions(ChatOptions.)
                .build();
    }
}
