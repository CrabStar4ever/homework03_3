package indi.study.controller;

import indi.study.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CoffeeController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/addCoffee")
    public void addCoffee (@RequestParam("name") String name, @RequestParam("price") BigDecimal price) {
        producerService.addCoffee(name, price);
    }

    @GetMapping("/addCoffee2")
    public void addCoffee2 (@RequestParam("name") String name, @RequestParam("price") BigDecimal price) {
        producerService.addCoffee2(name, price);
    }

}
