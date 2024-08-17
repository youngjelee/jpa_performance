package com.allmytour.ai.app.mock.controller;

import com.allmytour.ai.app.mock.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/comments")
    public void getComments(){
        testService.getComments();
    }

}
