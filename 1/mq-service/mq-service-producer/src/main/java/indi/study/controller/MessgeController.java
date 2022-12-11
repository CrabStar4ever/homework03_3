package indi.study.controller;

import indi.study.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessgeController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/sendMessage")
    public void sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
    }

}
