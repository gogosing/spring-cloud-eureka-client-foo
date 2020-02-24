package me.gogosing.controller;

import me.gogosing.model.external.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by JinBum Jeong on 2020/02/24.
 */
@RestController
@RequestMapping("/v1")
public class MessageController {

    private final RestTemplate restTemplate;

    public MessageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/message")
    public Map<String, String> getMessage() {
        String externalMessage = restTemplate
                .getForObject("//bar-service/v1/message", Message.class)
                .getMessage();
        return Map.of(
            "message", "Hello! I'm foo-service",
            "external", externalMessage
        );
    }
}
