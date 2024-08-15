package com.allmytour.ai.app.gpt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@RequiredArgsConstructor
@RequestMapping("/gpt")
public class GptController {
    private final ChatClient chatClient;
     @GetMapping("/question")
    public String question( String userInput) {

        String test = this.chatClient.prompt()
                .user("hihihi")
                .call()
                .content();
        System.out.println(test);

        return test;
    }

    @GetMapping("/getWeather")
    public String getWeather() {
        return "good";
    }
}
