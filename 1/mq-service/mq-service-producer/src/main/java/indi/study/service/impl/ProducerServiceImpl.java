package indi.study.service.impl;

import indi.study.model.Coffee;
import indi.study.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

@Slf4j
@Service
public class ProducerServiceImpl implements ProducerService {

    private BlockingQueue<Coffee> queue;

    private BlockingQueue<Coffee> kafka_queue;

    @PostConstruct
    private void init() {
        queue = new ArrayBlockingQueue<>(100);
        kafka_queue = new ArrayBlockingQueue<>(100);
    }

    @Bean
    public Supplier<Coffee> source() {
        return () -> {
            return queue.poll();
        };
    }

    @Bean
    public Supplier<Coffee> output() {
        return () -> {
            return kafka_queue.poll();
        };
    }

    @Override
    public void addCoffee(String name, BigDecimal price) {
        log.info("Producer produce a new coffee {} for ${}", name, price);
        Coffee coffee = new Coffee(UUID.randomUUID().toString(), name, price);
        boolean result = queue.offer(coffee);
        log.info("New coffee added with id:{}", coffee.getId());
    }

    @Override
    public void addCoffee2(String name, BigDecimal price) {
        log.info("Producer produce a new coffee {} for ${}", name, price);
        Coffee coffee = new Coffee(UUID.randomUUID().toString(), name, price);
        boolean result = kafka_queue.offer(coffee);
        log.info("New coffee added with id:{}", coffee.getId());
    }
}
